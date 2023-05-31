package lectures.part2oop

import lectures.part2oop.Exceptions.OverflowException

object Exceptions2 extends App {
  val x: String = null
  // println(x.length)
  // this will crash with NPE

  // 1. throwing and catching exceptions
  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception(code problem) and Error(smthg wrong with the system) are the major Throwable subtypes

  // 2. catching exceptions

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFail = try {
    // Code that may fail
    getInt(true)
  } catch {
    case e: RuntimeException =>
  } finally {
    // code that will get executed NO MATTER WHAT
    println("finally block")
  }

  // 3. how to define your own exceptions
  class MyException extends Exception

  // val exception = new MyException
  // throw exception

  /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with SOError
    3. PocketCalculator
        - add(x,y)
        - substract(x, y)
        - multiplay(x,y)
        - divide(x, y)
       Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if substract(x,y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
  */
  // OOM
  // val array = Array.ofDim(Int.MaxValue)

  // SO
  // def infinte: Int = 1 + infinte
  // val noLimit = infinte
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
  }


  println(PocketCalculator.add(Int.MaxValue, 10))
  // Takeawys
  //

}
