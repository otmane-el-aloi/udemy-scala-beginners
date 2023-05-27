package lectures.part1basics

/**
 * Created by Otmane EL ALOI
 */
object ValuesVariablesTypes2 extends App {
  // Vals are immutable! (intermediate computation to later use in other computations
  val x: Int = 42
  println(x)

  // Compiler can infer types
  val y = 43

  // semi-colons are allowed in Scala but not necessary
  // semi-colones is mandentory when writting multiple expressions on the same line
  val aString: String = "hello world!";

  val aBoolean: Boolean = true
  val anotherBoolean: Boolean = false

  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short= 4444
  val aLong: Long = 230423952342L
  // difference between floats and doubles (doubles are bigger than floats)
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // Variables in Scala
  var aVariable: Int = 12
  aVariable = 13 // side effects

  // Takeaways
  




}
