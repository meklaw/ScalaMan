package ru.meklaw
package lectures.week1basics

object StringOperations extends App {
  val aString: String = "Hello, world!"

  println(aString.length) // выводит 13
  println(aString.charAt(1)) // выводит e
  println(aString.substring(0, 2)) // выводит He
  println(aString.split(" ").toList) // выводит List(Hello,, world!)
  println(aString.startsWith("He")) // выводит true
  println(aString.replace("!", ".")) // выводит Hello, world.
  println(aString.toLowerCase) // выводит hello, world!
  println(aString.toUpperCase) // выводит HELLO, WORLD!
  println("abcd".reverse) // выводит dcba
  println("abcd".take(2)) // выводит ab
  println("abcd".take(1000)) // выводит ab

  /*
  1 добавление в начало подразумевает наличие двоеточия после  плюса. Соответственно, добавление в конец - перед плюсом
  2 +: или :+ подразумевает, что присоединять будем одиночные элементы (работаем с типом char)
  3 ++ или :++ указывает, что присоединять будем несколько элементов (используем элементы типа String), следовательно здесь уже понадобятся двойные кавычки
  4 внимание на типы, с которыми работаем: в нашем случае присоединения всегда происходит к элементам типа String (в примере это "42" и "bc")
*/
  println('1' +: "42" :+ '3') // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++ "bc" :++ "d") // abcd
  //На самом деле +, +: и :+ являются методами. Если навести на них указатель мышки/
  println(1 +: List(2, 3)) // List(1, 2, 3)
  println(List(1, 2) ++ List(3, 4)) // List(1, 2, 3, 4)
  println(List(1, 2) +: List(3, 4)) //List(List(1, 2), 3, 4)
  //   println('3' +: '4') - нельзя комбинировать Char


  //  s-интерполятор - используется для подставления значения переменной типа String в строку.
  val name = "John"
  val surname = "Smith"
  println(s"Hello, $name") // выводит Hello, John
  println(s"Hello, ${name ++ surname}") // выводит Hello, JohnSmith

  //  raw-интерполятор
  val someStr = "This is \n a string"
  println(raw"This is \n a string")
  println(raw"$someStr")
  println(s"This is \n a string")
}
