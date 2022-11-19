package ru.meklaw
package lectures.week2oop

import scala.language.postfixOps

object SyntacticSugar {
  def main(args: Array[String]): Unit = {
    class Person(val name: String, occupation: String) {
      def worksAs(jobName: String): Boolean = jobName == occupation

      def speaksEnglish: Boolean = true

//      работает только с операторами
      def &(person: Person): String = s"${this.name} and ${person.name} are colleagues"

//      пробел после ! обязателен
//      Префикс unary_ подходит только для + - ~ !
      def unary_! : String = s"$name is not real"

      def apply(): String = s"$name works as a $occupation"
    }
    val bob = new Person("Bob", "Developer")

    println(bob.worksAs("Developer")) // true

    //    Инфиксная нотация (Infix notation)
    println(bob worksAs "Developer") // true
    println(bob worksAs("Developer")) // true

    println(bob.speaksEnglish) // точечная нотация

    println(bob speaksEnglish) // постфиксная нотация
    /*Примечание: на практике инфиксная и постфиксная нотации применяются довольно редко.
    И предпочтение отдается точечной нотации, чтобы не вводить в заблуждение коллег.
    Кроме того, в версиях Scala, начиная с 2.13, постепенно уходят от постфиксных нотаций,
    что требует дополнительного импортирования import scala.language.postfixOps
    * */
    val alice = new Person("Alice", "Data Engineer")

    println(bob.&(alice)) // точечная нотация
    println(bob & alice) // инфиксная нотация

    println(!bob) // префиксная нотация
    println(bob.unary_!) // точечная нотация
    println(bob unary_!) // постфиксная нотация

//    способ вызвать apply
    println(bob.apply())
    println(bob()) // используется наболее часто
  }
}
