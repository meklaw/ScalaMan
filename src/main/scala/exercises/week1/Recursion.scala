package ru.meklaw
package exercises.week1

import scala.annotation.tailrec

object Recursion extends App {
  def powerOfTwo(n: Int): BigInt = {
    @tailrec
    def loop(n: Int, accumulator: BigInt = 1): BigInt = {
      if (n <= 0)
        accumulator
      else
        loop(n - 1, accumulator * 2)
    }

    loop(n)
  }

  //  println(powerOfTwo(0))
  //  println(powerOfTwo(1))
  //  println(powerOfTwo(2))
  //  println(powerOfTwo(3))
  //  println(powerOfTwo(4))
  //  println(powerOfTwo(33))
  //  println(powerOfTwo(1000))
  val x = 8
  val y = 4
  val n = 2

  def sum(x: Int, y: Int, n: Int): Int = {
    @tailrec
    def loop(n: Int = n, accumulator: Int = x): Int = {
      if (n <= 0) accumulator
      else loop(n - 1, accumulator + y)
    }

    loop()
  }

  //  println(sum(x,y,n)) // 16
  def printNumberCount(n: Int = sum(x, y, n)): Unit = {
    @tailrec
    def loop(accumulator: Int = n): Unit = {
      if (accumulator <= 0) {}
      else {
        print(s"$n ")
        loop(accumulator / 10)
      }
    }

    loop()
    println(s"is the result")
  }

  //  printNumberCount()
  //  printNumberCount(0)
  def reversAndPrintString(str: String): Unit = {
    val arr: Array[String] = str.strip().split("\\s+")

    @tailrec
    def reverse(n: Int = arr.length - 1): Unit = {
      if (n <= -1) {}
      else {
        print(s"${arr(n)} ")
        reverse(n - 1)
      }
    }

    reverse()
  }

  val test = "I like     Scala"
  reversAndPrintString(test)
}
