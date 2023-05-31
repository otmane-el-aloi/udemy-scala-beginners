package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure2 extends App {
  // create success and failutre explicitly
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU ")
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }
  // utilities
  println(potentialFailure.isSuccess)
  println(potentialFailure.isFailure)

  // orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // If you desing the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallBack = betterUnsafeMethod() orElse betterBackupMethod()

  // map, flatMap, filter
  println(aSuccess.map(_ * 2 ))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
  // => for-comprehensions

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>..</html>"
      else throw new RuntimeException("Connection interrupted!")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port:String): Try[Connection] = Try(getConnection(host, port))
  }

  // if you get the html page from the connection, print it to the console i.e call renderHTML
  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  // shorthand version
  HttpService.getSafeConnection(hostname, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for-comprehension
  for {
    connection <- HttpService.getSafeConnection(hostname, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)

  // Takeawys
  // Use Try to handle exceptions gracefully
  // * avoid runtime crashes due to uncaught exceptions
  // * avoid an endless amount of try-catches
  // A functional way of dealing with failure
  // * map, flatMap, filter
  // orElse
  // others: fold, collect, toList, conversions to Options




}
