package lectures.part4pm

import lectures.part2oop.Generics2.MyList

object AllThePatterns2 extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns2 => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 varibale
  val matchVariable = x match {
    case something => s"I ve found $something"
  }

  // 3 - tuples
  val aTuple = (1, 2)
  val matchAtuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I 've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  // PMs can be NESTED!

  // 4 - case classes - constructor pattern
  // 5- list patterns
  val aStandradList = List(1, 2, 3, 42)
  val aStandardListMatching = aStandradList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 => // infix pattern
  }

  // 6 - type specifiers
  val unkown: Any = 2
  val uknownMatch = unkown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - name binding
  val aList = List(1, List(2, 3))
  val nameBindingMach = aList match {
    case nonEmptyList @ List(_, _) => // name binding => use the name later(here)
    case List(1, rest @ List(2, _)) => // name binding inside nested patterns
  }

  // 8 - multi-patterns
  val multipattern = aList match {
    case null | List(0, _) => // compound pattern (multu-pattern)
  }

  val numbers = List(1, 2, 3)
  val numberMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }
  println(numberMatch)



}
