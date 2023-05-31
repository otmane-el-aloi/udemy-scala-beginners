package lectures.part2oop

object AnonymousClasses2 extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahha")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how could I help you")
  }

  // Don't forget to pass parameters
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how could I help you")
  }

  // TakeAways
  // We can instatiate types and override fields or methods on the spot
  // Rules:
  // * pass in required constructor arguments if needed
  // * implement all abstract fields/methods





}
