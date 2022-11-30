package ru.meklaw
package lectures.week3fp

object Collections {
  def main(args: Array[String]): Unit = {
    /*
      Set ( т.е. без дубликатов или повторяющихся элементов)
      Seq (т.е. у каждого элемента свой индекс, например - Vector, Range, List, Array)
      Map (т.е. пары ключ-значение)
      По умолчанию структуры данных неизменяемые
*/

    println("Set:")
    val emptySet: Set[Int] = Set()
    val aSet = Set(10, 20, 30, 40)
    val anotherSet = Set(30, 40, 50, 60)

    //    10
    println(aSet.head)
    //    Set(20, 30, 40)
    //    Set(30, 40)
    println(aSet.intersect(anotherSet))
    println(aSet & anotherSet)

    //    HashSet(10, 20, 60, 50, 40, 30)
    aSet.++(anotherSet)
    aSet ++ anotherSet
    println(aSet ++ anotherSet)

    println()
    println("Seq:")

    val aSeq = Seq(1, 3, 2, 4)
    println(aSeq)
    //    List(1, 3, 2, 4, 6,7,5)
    aSeq ++ Seq(6, 7, 5)
    //    3
    aSeq(1)
    //    возвращает индекс найденного элемента: Found(1)
    aSeq.search(3)

    println()
    println("Map:")

    val aMap: Map[String, Int] = Map()
    val colors: Map[String, String] =
      Map(("black", "#000000"), "blue" -> "#0d1ad1").withDefaultValue("na")
    println(colors)
    //    #000000
    println(colors("black"))
    //    na
    println(colors("red"))

    //    тип Tuple2
    val color: (String, String) = "green" -> "#339616"
    val newColors = colors + color
    println(newColors.toList)
    println(List("white" -> "#ffffff", ("blue", "#0d1ad1")).toMap)

    println()
    println("Array:")

    val anArray: Array[String] = Array("h", "e", "llo", ".")
    //    anArray.update(3, "!")
    anArray(3) = ""
    println(anArray.mkString("-"))

    //    создание массива заданного размера
    val twoElen: Array[Boolean] = Array.ofDim[Boolean](2)

    //    преобразование типа Array[String] -> ArraySeq[String]
    val numberSeq: Seq[String] = anArray

    println()
    println("Tuple:")

    //    Tuple - содержит элементы разных типов (размера от 1 до 22)
    val aTuple: (Int, String) = (100, "Scala")

    println(aTuple._1)
    println(aTuple._2)

    val copy: (String, Int) = aTuple.copy(_2 = "Kotlin").swap

    println()
    println("Range:")
    //    3 не включит
    val aRange: Seq[Int] = 1 until 3

    //    HelloHelloHello
    (1 to 3).foreach(x => print("Hello"))

    val aRangeToVector: Vector[Int] = (1 to 5).toVector
    println(aRangeToVector)


    println()
    println("for:")
    val list = List(1, 2, 3)
    list.foreach(print)
    println()

    for {
      n <- list
    } print(n)
    println()

    for {
      n <- 1 until 4
    } print(n)
    println()

    println()
    println("map, flatMap, filter:")
    val fruits = List("apple", "banana")

    val mapResult = fruits.map(_.toUpperCase)
    val flatResult = fruits.flatMap(_.toUpperCase)

    println(mapResult) // List(APPLE, BANANA)
    println(flatResult) // List(A, P, P, L, E, B, A, N, A, N, A)

    val s = "Hello"
    val newStr: String = s.flatMap(c => (c + "."))
    println(newStr) // H.e.l.l.o.

    println(s.map(c => (c + "."))) // ArraySeq(H., e., l., l., o.)


    val list1 = List(1, 2, 3)
    val list2 = List("a", "b")

    val forCombination = for {
      n <- list1
      c <- list2
    } yield c + n

    println(forCombination)
    println(list1.flatMap(n => list2.map(c => c + n)))
    /*flatten
    flatten сжимает вложенные структуры.
    scala> List(List(1, 2), List(3, 4)).flatten
    res0: List[Int] = List(1, 2, 3, 4)
    flatMap это часто используемый комбинатор,который объединяет map и flatten.
    latMap берет функцию, которая работает с вложенными списками и объединяет результаты
    */
    val progLanguages = List("java", "scala", "python")
    val lngAbbrev = List("JA", "SCA", "PY")

    val out = lngAbbrev.flatMap(abrv => progLanguages.filter(_.startsWith(abrv.toLowerCase)).map(lang => (abrv, lang)))

    println(out)

    println("Scala" + 5)
  }
}
