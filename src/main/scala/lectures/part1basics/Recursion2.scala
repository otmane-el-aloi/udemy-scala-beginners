package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion2 extends App {
  // Show recursion stack
  def factorial(n: Int): Int = {
    if (n<=1) 1
    else {
      println("Stack: Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }
  println(factorial(10))
  //println(factorial(50000)) StackOverflowError

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x<=1) accumulator
      else factorialHelper(x-1, x * accumulator) // Tail recursion = use recursive call as the last expression
    }
    factorialHelper(n, 1)
  }
  println(anotherFactorial(500))
  // When we need loops, we should use tail recustion

  // Exercises
  // 1. Concatenate a string n  times

  def concatString(s: String, n: Int): String = {
    @tailrec
    def concatHelper(n: Int, accumulator: String): String = {
      if (n==1) accumulator
      else concatHelper(n-1, s + " " + accumulator)
    }
    concatHelper(n, " ")
  }

  // TODO: 2. isPrime function tail recursive


  // TODO: 3. Fibonnacci function, tail recurisve
}
