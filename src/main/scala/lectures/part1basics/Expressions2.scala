package lectures.part1basics

object Expressions2 extends App {
  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  // + - * / (+ bit wise operations)

  println( 1 == x)
  // == != > >= <=

  println(!(1==x))
  // ! && ||

  var aVariable = 2
  aVariable +=2 // this also works with other maths operations .... side effects
  println(aVariable)

  // Instructions (tell the computer to DO) vs Expressions (Value)
  // If experssion
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // If expression not an if instruction  (it actually returns a value)
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // Never write this again (Loops are very specific to imperative programming like Java, Python or C)

  // Scala forces everything to be an expression!

  // Side effects in Scala are actually expression returning Units
  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "good bye"
  }
  // Code blokcs are expressions, the value of the block is the value of the last expression
  // Values inside the code block are only visible inside the code block

  // Exercices
  // 1. difference between "hello world" vs println("hello world")?
  // 2.

  val someValue = {
    2<3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
}
