package lectures.part2oop

object AbstractDataTypes2 extends App{
  // Abstract (cnnot be instanciated)
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferedMeal: String = "fresh meat"
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = thing

  // Scala's Type Hierarchy
  //                                                        Scala.Any
  // Scala.AnyVal (Int, Unit, Boolean, Flaot...)                            Scala.AnyRef(java.lang.Object) (String, List, Set extends Scala.AnyRef..)
  //                                                                               Scala.Null
  //                                      Scala.Nothing


}
