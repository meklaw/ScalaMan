package ru.meklaw
package lectures.week3fp

object Options {
  def main(args: Array[String]): Unit = {
    def unsafeMethod(): String = null

    def safeMethod(): String = "There is a String"

    def maybeSafeMethod(): String = "There is no harm"

    val unsafeRes = Option(unsafeMethod())
    val safeRes = Option(safeMethod())

    println(unsafeRes) // None
    println(safeRes) // Some(There is a String)
    //    Т.е. Option вернет None при отсутствии значения и Some со значением, если значение есть.

    val someOption: Option[String] = Some("Success")
    val noneOption: Option[Int] = None

    println(someOption.isEmpty) // false
    println(noneOption.isEmpty) // true


    val chainedResult = Option(unsafeMethod()).orElse(Option(maybeSafeMethod()))
    println(chainedResult) // Some(There is no harm)

    val someVal = Some(2)
    //    Some(4)
    println(someVal.map(_ * 2))
    //    Зачастую необходимо трансформировать значение внутри Option, если оно вообще там имеется.
    //    Для этого существует метод map: он вынимает значение, преобразовывает его и упаковывает обратно в контейнер.


  }
}
