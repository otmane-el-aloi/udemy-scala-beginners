package lectures.part1basics

object StringsOps2 extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(0,2))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "--"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')
  println(str.reverse)

  // S-interpolators
  val name = "David"
  val age = 12
  val anotherGreetings  = s"Hello, my name is $name and I will be turining ${age + 13}  years old next year"
  println(anotherGreetings)

  // F-interpolators
  val speed = 1231.2f
  val myth = f"$name can eat $speed%2.2f"
  println(myth)

  // raw-interpolator
  println(raw"This is \n newline")
  val escaped = "This is a \n newline"
  print(raw"$escaped")




}
