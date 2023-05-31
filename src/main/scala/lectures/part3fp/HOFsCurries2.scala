package lectures.part3fp

object HOFsCurries2 extends App {
  // Higher order function (HOF)
  // map, flatMap, filter in MyList
  // function that appliers a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n==1) f(x)
    else nTimes(f, n-1, f(x))
  }
  val inc: Int => Int = _ + 1
  println(nTimes(inc, 1, 2))

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)
  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  // Takeaways
  // Functional programming = working with functions
  // * pass functions as parameters
  // * return functions as results
  // HOFs: functions that takes functions as parameters or return functions
  // Currying = functions with multiple parameter lists



}
