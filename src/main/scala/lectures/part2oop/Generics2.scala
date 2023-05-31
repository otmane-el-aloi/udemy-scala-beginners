package lectures.part2oop

import lectures.part2oop.Generics2.Animal

object Generics2 extends App {
  class MyList[+A] {
    // use the type A inside the class definition
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
    * */
  }
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovarianList[+A]
  val animal: Animal = new Cat
  val animalList: CovarianList[Animal] = new CovarianList[Cat]
  // animalList.add(new Dog)??? HARD QUESTION

  // 2.No, List[Cat] and List[Animal] are two separate things = INVARIANCE
  class InvariantList[A]
  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded types
  class Cage[A <: Animal] (animal: A) // class Cage[A >: Animal] (animal: A)
  val cage = new Cage(new Dog)

  class Car
  //val newCage = new Cage(new Car)

  // expand MyList to be generic

  // Takeawys
  // Generics: Use the same code on many(potentially unrelated) types
  // Generic class class List[T]
  // Generic methods def add[B](element: B): List[B]
  // Multiple type parameters class Map[Key, Value]
  // Variance: if extends A, should List[B] extends List[A]


}
