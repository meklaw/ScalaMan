package ru.meklaw
package lectures.week3fp

import scala.util.{Failure, Success, Try}

object ExceptionsFP {
  def main(args: Array[String]): Unit = {
    def unsafeMethod(): String = throw new RuntimeException("Sorry, not your day")

    def myMethod(): String = "My method is valid"

    val potentialFailure = Try(unsafeMethod())
    println(potentialFailure) // Failure(java.lang.RuntimeException: Sorry, not your day)

    val anotherPotentialFailure = Try {
      // код, содержащий исключения
    }

    println(potentialFailure.isSuccess) // false

    val executeWithTry = Try(unsafeMethod()).orElse(Try(myMethod()))

    println(executeWithTry) // Success(My method is valid)

    //    оборот в Try результата работы метода
    def methodWhichFails(): Try[String] = Failure(new RuntimeException("Ooops..."))

    def methodWhichSucceeds(): Try[String] = Success("Everything is OK")

    val tryMethods = methodWhichFails() orElse methodWhichSucceeds()

    println(tryMethods) // Success(Everything is OK)
  }
}
