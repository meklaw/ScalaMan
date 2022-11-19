package ru.meklaw
package lectures.week1basics

object Functions extends App {
  def aPerson(name: String, surname: String): String = {
    s"$name $surname"
  }

  def aFunctionWithDefaultParameter(x: Int, y: String = "Default Parameter"): String = {
    s"x = $x and y = $y"
  }

  println(aFunctionWithDefaultParameter(1)) // выводит x = 1 and y = Default Parameter

  /*Смотрите: для callByValue мы вычислили значение System.nanoTime() и подставили это значение в функцию.
  Однако для callByName предварительных вычислений не делалось, и значение высчитывалось уже непосредственно в функции*/
  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())
  //"call by name" - это именно "ленивость" + "отсутствие ссылочной прозрачности"

  /*
  Это полезно для разбиения функции на обертку и рекурсивную подфункцию, по крайней мере такое встречал часто:
def wrapperFun(_*): T = {
   def recursiveFun(_*, acc: T) = {
        // do recursive calculation
    }

   recurciveFun(_*, initialAccValue)
}*/
}
