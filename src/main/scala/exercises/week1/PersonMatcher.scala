package ru.meklaw
package exercises.week1

import scala.util.Try

object PersonMatcher {
  def main(args: Array[String]): Unit = {
    val input = Try(scala.io.StdIn.readLine())

    if (input.isSuccess)
      println(checkFullName(input.get))
    else
      println("Oops, something is wrong")
  }

  def checkFullName(fullName: String): String = {
    val (name, surname) = Try(splitFullName(fullName)).getOrElse("", "")

    if (name.nonEmpty && surname.nonEmpty) {
      s"${name(0)}. ${surname(0)}."
    } else
      "Oops, something is wrong"
  }

  def splitFullName(str: String): (String, String) = {
    val name = str.strip().split(" ")(0)
    val surname = str.strip().split(" ")(1)

    (name, surname)
  }
}
