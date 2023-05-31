package lectures.part3fp

object MapFlatMapFilterFor2 extends App {
  val list = List(1, 2, 3)
  println(list.head)
  print(list.tail)

  // map
  println(list.map(_ + 1))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')

  // List("a1", "a2"..."d4")
  val combinations = chars.flatMap(x => numbers.map(n => s"$x$n"))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n%2 == 0 // Adding guards
    c <- chars
  } yield "" + c + n
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map {x =>
    x*2
  }
  








}
