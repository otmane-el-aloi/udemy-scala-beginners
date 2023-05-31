package lectures.part2oop

import javax.management.openmbean.OpenMBeanConstructorInfoSupport

object InheritanceAndTraits2 extends App{

  // Single class inheritance
  class Animal {
    val creatureType = "wild"
    // Access modifiers: private (accessed only within the parent class),
    // protected accessed inside the parent and inside children classes
    // public accessed everywhere
    def eat = println("nom nom nom")
  }

  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  println(cat.crunch)

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("beh beh beh")
    }
  }

  val dog = new Dog
  println(dog.eat)
  println(dog.creatureType)

  // Type Substitution (broad: polymorhism) --> the most overriden method is used
  val unknownAnimal: Animal = new Dog
  println(unknownAnimal.eat)

  // overRIDING vs overLOADING

  // Super
  // Preventing ovverides
  // 1. using the final key word
  // 2. use final on the entire class
  // 3. seal the class = extend classes in this file, prevent extension in other files
  
}
