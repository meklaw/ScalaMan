package ru.meklaw
package lectures.week3fp

import scala.annotation.tailrec
import scala.language.postfixOps

object FunctionsFP {
  def main(args: Array[String]): Unit = {
    val product1 = new Function2[Int, Int, Int] {
      override def apply(v1: Int, v2: Int): Int = v1 * v2;
    }
    val product2 = (x: Int, y: Int) => x * y
    val product3: (Int, Int) => Int = (x, y) => x * y
    val product4: (Int, Int) => Int = _ * _
    //    задаёт тип
    //    val product5: Int = (x: Int, y: Int) => x * y

    //    val strlen = (_: String) length
    //    val strlen = (_: String) .length
    //    val strlen : String => Int = _.length
    //    val strlen: String => Int = a => a.length
    //    val strlen = (s: String) => s.length
    //    val strlen = (s: String) => { s.length }
    //    val strlen = {(s: String) => s.length }
    //    val strlen: String => Int = { s => s.length }
    //    val strlen: String => Int = { _.length }
    //    val strlen = { (_: String).length }

    @tailrec
    def nTimes(f: Int => Int, x: Int, n: Int): Int = {
      if (n <= 0) x
      else nTimes(f, f(x), n - 1)
    }

    val increment: Int => Int = (x: Int) => x + 1

    println(nTimes(increment, 5,5))

//    каррирование
    def add(x: Int)(y: Int) = x + y
    println(add(1)(2))

    def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
      if (n <= 0) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
      else (x: Int) => curryingNTimes(f, n-1)(f(x))
    }
    println(curryingNTimes(increment, 3)(0))

//    def createURL(baseURL: String, path: String) = s"https://${baseURL}/${path}"
//
//    createURL("stepik.org", "login" )
//    createURL("stepik.org", "contact" )
//    createURL("mail.google.com", "login")

    def createURL(baseURL: String) = (path: String) => s"https://${baseURL}/${path}"

    val stepikURL =  createURL("stepik.org")
    val googleURL = createURL("mail.google.com")

    stepikURL("login")
    stepikURL("contact")

    googleURL("login")

    /*sort(byCountry, byName)
    * sort(byCountry, bySurname)
    *
    * Каррирование
    * sortByCountry = sort(byCountry)
    * sortByCountry(byName)
    * sortByCountry(bySurname)
    *
    *
    * тип A => B - это синоним типа Function1[A, B]
    * тип (A1, A2) => B - синоним для Function2[A1, A2, B]
    * и т.д.
    * а тип
    * A => B => C - это то же самое, что Function1[A, Function1[B, C]]
    * */
  }
}
