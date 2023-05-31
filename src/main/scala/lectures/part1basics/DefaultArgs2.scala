package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs2 extends App {

  @tailrec
  def trFactorial(n: Int, acc: Int = 1): BigInt = {
    if (n <=1) acc
    else trFactorial(n-1, n*acc)
  }

  // Degault arg is used for accumulator
  val fatc10 = trFactorial(10)

  // if all parameters have default args the compiler is confused
  // if there are mixed parameters (defaulted with non defaulted) the defaulted should be placed last
  def savePicture(width: Int, height: Int, format: String = "jpg"): Unit = println("Hello World!!")
  savePicture(800, 600)

  savePicture(height = 600, width = 800, format = "bmp")

}
