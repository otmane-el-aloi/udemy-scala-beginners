package lectures.part2oop

import scala.util.Random

object Options2 extends App{
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)

  // unsafe APIs
  def unsafeMethod(): String = null
  //val result = Some(unesafeMethod()) // WRONG
  val result = Option(unsafeMethod()) // Some or None depending on whteher the value of unsafe is null or note
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE - DO NOT USE THIS

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions
  val config: Map[String, String] = Map(
    // feteched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect: String= "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")
  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)
    return null

  */
  val cnx = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  /*
    if (c != null)
      return c.connect
    return null
  */
  val cnxStatus = cnx.map(c => c.connect)
  println(cnxStatus)

  cnxStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
        .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  val connectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  connectionStatus.foreach(println)

  // Takeaways
  // Use Options to stay away from the Boogeyman:
  // * avoid runtime crashes due to NPEs
  // * avoid an endless amount of null-related assertions

  // A functional way of dealing with absence
  // * map, flatMap, filter
  // * orElse
  // others: fold, collect, toList

  // if you design a method to return a (some type) but may return null
  // return an Option[that type] instead


}
