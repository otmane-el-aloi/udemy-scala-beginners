package lectures.part2oop

object CaseClasses2 extends App {
  /*
  * equals, hashCode, toString
  * */
  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim.toString)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy methods
  val jim3 = jim.copy(age = 23)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // apply method of compaion object

  // 6. CCs are serializable (used when dealing with distributed systems)
  // Akka

  // 7. CCs have extractor patterns= = CCs can be used in Pattern Matching

  case object UnitedKingodm{
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList
  */

  // Takeawys
  // Quick lightweight data structure with little boilerplate
  // Companions alreay implemented
  // Sensible equals, hascCode, toString
  // Auto-promoted params to fields
  // Cloning








}
