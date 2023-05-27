package lectures.part1basics
import scala.math.*



object Functions2 extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  // When you need loops use recursion (fundamental idea in functional programming)
  def aReaptedFunction(aString: String, n: Int): String = {
    if (n==1) aString
    else aString + "\n" +  aReaptedFunction(aString, n-1)
  }
  println(aReaptedFunction("hello", 5))


  def aFunctionWithSideEffects(aString: String): Unit = {
    println(s"$aString")
  }

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  // Exercises
  // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  def greetingFunction(name: String, age: Int): String = s"Hi, my name is $name and I am $age years old"
  println((greetingFunction("Otmane", 24)))

  // 2. Factorial function 1*2*3...*n
  def factorial(n: Int): Int = {
    if (n<=0) 1
    else n * factorial(n-1)
  }
  println(factorial(5))

  // 3. Fibonnacci function f(1) = 1 , f(2) = 1 , f(n) = f(n-1) + f(n-2)
  def fibo(n: Int): Int = {
    n match
      case 1 => 1
      case 2 => 1
      case _ => fibo(n-1) + fibo(n-2)
  }
  println(fibo(4))

  // 4. Test if a number is prime
  // My first attempt
  def isPrime(n: Int): Boolean = {
    def isDivider(n: Int, d: Int) = n%d == 0
    var d = ceil(sqrt(n)).toInt
    var isNotPrime: Boolean = true
    while (d > 1) {
      if (isDivider(n, d)) {
        isNotPrime = false
      }
      d -= 1
    }
    isNotPrime
  }
  println(isPrime(4))

  // My second attempt
  def isPrimeNumber(n: Int) = {
    def isPrimeUntil(d:Int): Boolean = {
      if (d <= 1) true
      else isPrimeUntil(d-1) && n%d !=0
    }
    isPrimeUntil(n/2)
  }
  println(isPrimeNumber(5))
}
