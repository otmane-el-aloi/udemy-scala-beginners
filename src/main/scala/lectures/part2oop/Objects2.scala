package lectures.part2oop

object Objects2 {
  // Scala doesn't have class level functionallity ("static")
  // Objects do not receive parameters
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method (build persons given some parameters)
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  // Companion of Person Object
  class Person(val name: String){
    // instance-level functionality
  }
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala Object = Singleton instance
    val mary = new Person("Mary")
    val john = new Person("John")

    // They point to the same instance
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobie = Person.apply(mary, john)
    val roze = Person(mary, john)
  }

  // Scala Applications = Scala Object with
  // def main(args: Array[String]): Unit
  // A shorter way is to use the extends App method

  // Takeaways
  // Scala doesn't have "static" values/methods
  // Scala objects:
  // * are in their own class
  // * are the only instance
  // * singleton pattern in one line!
  // Scala companions:
  // * can access each other's private members
  // * Scala is more OO than Java!
  // Scala applications:
  // * Objects with def main methods
  // * objects that extends App
}
