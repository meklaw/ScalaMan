package ru.meklaw
package lectures.week2oop

object Exceptions {
  def main(args: Array[String]): Unit = {
    try {
      throw new RuntimeException()
    } catch {
      case e: RuntimeException => println("RTE here")
    } finally {
      println("finally")
    }

    //    тип Any
    val potentialException = try {
      true
    } catch {
      case e: RuntimeException => println("RTE is here")
    } finally {
      println("I will be there no matter what")
    }
//    тип Int
    val potentialException2 = try {
      2
    } catch {
      case e: RuntimeException => 4
    } finally {
      println("I will be there no matter what")
    }
    println(Int.MinValue -1 )
    /*
    * блоки Try и catch возвращают данные
    * тип объединяется (potentialException )
    * final ничего не возвращает*/

    /*тип Nothing может стать чем-то - это всё
    * все реализует Any
    * а AnyVal -> Any (обёртка для примитива)
    * AnyRef -> Any
    * */
//    val exceptionVal = throw new NullPointerException
//    val exceptionVal2: Int = throw new NullPointerException
  }
}
