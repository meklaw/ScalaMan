package ru.meklaw
package lectures.week1basics

object CodeBlock extends App {
  val aCodeBlock = {
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false
  }

  println(aCodeBlock) // выводит true

  val bCodeBlock = {
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false

    "String to return"
  }
  println(bCodeBlock) // выводит "String to return"

  /*ошибка
  val cCodeBlock: Boolean = {
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false

    "String to return"
  }*/


}
