package lectures.part3fp

object AnonymousFunctions2 extends App {

  val doubler = new Function[Int, Int]{
    override def apply(x: Int): Int = x * 2
  }

  // anonymous function (Lambda)
  val doublerBetter: Int => Int = x => x * 2

  // multiple parameters
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSm: () => Int = () => 3

  // careful
  println(justDoSm)
  println(justDoSm())

  // curly braces with lambdas
  val stringToInt = { (str:String) => str.toInt}

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int  = _ + 1 // equivalent to x => x +1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  val specialAdder: Int => Function1[Int, Int] = x => {(y: Int) => x + y}
  println(specialAdder(2)(3))

  val toStringFunction = new Function1[Int, String] {
    override def apply(x: Int): String = x.toString
  }

  val shotToStringFucntion: Int => String = x => x.toString
  val shorterToStringFunction: Int => String = _.toString // Only when the params is used one time
  println(toStringFunction(3343))

}
