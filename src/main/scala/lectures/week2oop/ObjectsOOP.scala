package ru.meklaw
package lectures.week2oop

object ObjectsOOP {
  def main(args: Array[String]): Unit = {
    /*объекты object
    * не имеют параметров
    * являются одиночками (Singleton Object)
    *
    * Если в одном и том же файле и под одним и тем же именем объявить объект и класс,
    * то в таком случае их можно смело назвать компаньонами.
    * Объект имеет доступ ко всем полям и методам своего класса-компаньона (в том числе и private).
    * */
    // опускаем наименование метода apply и сразу пишем необхоимые для этого метода параметры
    println(MyString("hello", "world")) // helloworld
    println(MyString("welcome")) // welcomeextraData
  }
}

class Number(val num: Int)

object Number {
  val Pi = 3.14
  /*
  доп фабричный метод который позволяет писать так
  val numA = new Number(1)
    val numB = new Number(2)

    val numC = Number(numA, numB) // применяем apply
  */

  def apply(x: Number, y: Number): Number = new Number(x.num + y.num)
}

class MyString(val str: String) {
  private var extra = "extraData"

  override def toString: String = str + extra
}

object MyString {
  def apply(base: String, extras: String): MyString = {
    val s = new MyString(base)
    s.extra = extras
    s
  }

  def apply(base: String) = new MyString(base)
}