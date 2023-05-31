package lectures.part3fp

import scala.util.Random

object Sequences2 extends App {
  // Sequences
  // A very general inteface for data structures that:
  // * have a  well defined order
  // * can be indexed
  // Supports various operations
  // * apply, iterator, length, reverse for indexing and iterating
  // * concatenation, appending, prepending
  // * A lot of others: grouping, sorting, zipping, searching, slicing

  val aSequence = Seq(1, 2, 3, 4, 0)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)
  (1 to 10).foreach(x => println("Hello")) // Extremely used in Practice

  // Lists
  val aList = List(1, 2 , 3)
  val prepended = 42 :: aList // 42 +: aList :+ 89
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-"))

  // Arrays
  // The equivalent of simple Java Arrays
  // Can be manually constructed with predefined lenghts
  // Can be mutated (updated in place)
  // Are interoperable with Java's T[] arrays
  // indexing is fast

  val numbers = Array(1, 2, 4, 5)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0
  threeElements.foreach(println)

  // Arrays and Seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // Vectors
  // The default implementation for immutable sequences
  // * effectively constant indexed read and write: O(log32(n))
  // * fast element addition: append/prepend
  // * implemented as a fixed-branched trie (branch factor 32)
  // * good performance for large sizes

  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs lists
  val MAX_RUNS = 1000
  val MAX_CAPACITY = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to MAX_RUNS
    } yield {
      val currentTime = System.nanoTime()
      // operation
      collection.updated(r.nextInt(MAX_CAPACITY), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / MAX_RUNS
  }

  val numbersList = (1 to MAX_CAPACITY).toList
  val numbersVector = (1 to MAX_CAPACITY).toVector

  // keeps reference to tail
  // updating an element in the middle takes long
  println(getWriteTime(numbersList))

  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))
















}
