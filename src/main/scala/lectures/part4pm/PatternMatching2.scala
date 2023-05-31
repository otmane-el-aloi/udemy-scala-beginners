package lectures.part4pm
import scala.util.Random

object PatternMatching2 extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "The one"
    case 2 => "Double or nothing"
    case _ => "I got the picture" // = WILDCARD
  }

  println(x)
  println(description)

  // 1. decompose values (used in conjonction with case classes)
  case class Person(name:String, age:Int)
  val bob = Person("Bob", 24)

  val greetings = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and I am $a years old and I can't drink in the US" // the if expression is called a guard
    case Person(n, a) => s"Hi my name is $n and I am $a years old"
    case _ => "I don't know who I am I"
  }

  println(greetings)

  /*
    1. cases are matched in order
    2. what if no cases match
    3. type of PM expressions? unified type of all the types in all the cases
    4. PM works really well with case classes
  */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  // match everything ??
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  val isEvenCond = if (x % 2 == 0) true else false // ?
  val isEvenNormal = x % 2 == 0

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr


  def deconstruct(exp: Expr): String = {
    exp match {
      case Number(n) => "" + n
      case Sum(e1, e2) => "(" + deconstruct(e1) + "+" + deconstruct(e2) + ")"
      case Prod(e1, e2) => "(" + deconstruct(e1) + "*" + deconstruct(e2) + ")"
    }
  }
  val testExpression = Prod(Sum(Number(2), Number(1)), Number(3))
  println(deconstruct(testExpression))


}
