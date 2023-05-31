package lectures.part3fp

object WhatsAFunction2 extends App {
  // DREAM: use functions as first class elements
  // problem: oop
  val doubler = new MyFunction2[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(s: String): Int = s.toInt
  }
  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int): Int = a + b
  }

  // function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS
  val concatenate: (String, String) => String = new Function2[String, String, String] {
    override def apply(s1: String, s2: String): String = s1 + " "  + s2
  }
  println(concatenate("Hello", "Otmane"))

  // Curried Function
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]]{
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4))

  // Takeaways
  // We want to work with functions:
  // * pass functions as parameters
  // * use functions as values

  // Problem: Scala works on top of the JVM
  // * designed for Java
  // * first-class elements: objects(instances of classes)

  // Solution: All Scala functions are objects
  // * function traits, up to 22 params
  // * syntactic sugar functions types (Int, String) => Int === Function2[Int, String, Int]
}

trait MyFunction2[A, B] {
  def apply(element: A): B
}
