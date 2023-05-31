package lectures.part3fp

object TuplesAndMpas2 extends App {
  // tuple = finite ordered "lists"
  val aTyple = Tuple2(2, "Hello, Scala") // Tuple2[Int, String] = (Int, String)
  val anotherTuple = (2, "hello, Scala")

  println(aTyple._1)
  println(aTyple._2)

  println(aTyple.copy(_2 = "goodbye Java"))
  println(aTyple.swap) // ("Hello, Scala", 2)

  // Maps- keys => Values
  val aMap: Map[String, Int] = Map()
  val phoneBook = Map(("Jim", 555), ("Danial", 789)).withDefaultValue(-1) // syntactic sugar for tuple ( x, y) === x -> y

  // maps ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary"))

  // Add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phoneBook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.filter(x => x._1.startsWith("J")))

  // mapValues
  println(phoneBook.map(x => (x._1, x._2 * 10)))

  // conversions to other collections
  println(phoneBook.toList)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
