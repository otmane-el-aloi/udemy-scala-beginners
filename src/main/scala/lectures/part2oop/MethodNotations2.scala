package lectures.part2oop
import scala.language.postfixOps

object MethodNotations2 extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // syntactic sugar : natural language like notation
  println(mary likes "Inception") // equivalent (infix notation = operator notation (only works with methods with a single paramater)

  // "Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith(tom))

  // All operators are methods
  println(1 + 2)
  println(1.+(2))

  // Akka actors have ! ? operators

  // Prefix notation
  val x = -1 // equivalant with 1.unuary_-
  val y = 1.unary_-

  // unary_ prefix works only with some operators + - ~ !
  println(!mary)
  println(mary.unary_!)

  // Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // Apply
  println(mary.apply())
  println(mary())
}
