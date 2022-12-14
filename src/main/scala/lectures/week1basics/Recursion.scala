package ru.meklaw
package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s"Имеем число $n, для которого считаем факториал ${n - 1}")
      var res = n * factorial(n - 1)
      println(s"Вычислили факториал $n")

      res
    }
  }

  //  factorial(3)

  //  хвостовая рекурсия
  def factorialWithTailRecursion(n: Int): Int = {
    @tailrec
    def loop(x: Int, accumulator: Int = 1): Int = {
      if (x <= 1) accumulator
      else loop(x - 1, x * accumulator)
    }

    loop(n)
  }

  /*1. Определяете функцию. Назовем ее основной.
  2. Внутри основной функции прописываете еще одну функцию. Назовем ее вспомогательной.
  3. В качестве аргументов вспомогательной функции указываете число вызовов
  (этот аргумент совпадает с одним из аргументов основной функции) - плюс аккумулятор, который будет содержать конечный результат.
  4.  Прописываете код с рекурсией в теле вспомогательной функции с использованием аккумулятора (так, чтобы значение постепенно накапливалось)
  5. Вызываете вспомогательную функцию из основной функции.
  Не забудьте указать начальное значение аккумулятора, задающее отправную точку всех вычислений.
   Используйте аргумент по умолчанию для оптимизации кода.
Если вы не уверены, действительно ли вы имплементировали хвостовую рекурсию - можете воспользоваться аннотацией   @tailrec.
Этим вы укажете компилятору, что функция должна быть tail recursive, и если это не так, ваш код просто не запустится.
*/
  def printWord(word: String, n: Int = 1): Unit = {
    @tailrec
    def loop(n: Int): Unit = {
      if (n <= 0) {
      } else {
        println(word)
        loop(n - 1)
      }
    }

    loop(n)
  }

  printWord("ab")
}
