package ru.meklaw
package exercises.week1

object GenericList {
  def main(args: Array[String]): Unit = {
    val intLogs: LogList[Int] = Empty
    val strLogs: LogList[String] = Empty
    println("lol")
  }
}

sealed abstract class LogList[+A] {
  def last(): A

  def previous(): LogList[A]

  def isEmpty: Boolean

  def all(): String

  def add[B >: A](msg: B): LogList[B]
}

class Log[+A](head: A, tail: LogList[A]) extends LogList[A] {
  override def last(): A = head

  override def previous(): LogList[A] = tail

  override def isEmpty: Boolean = false

  override def all(): String = {
    head.toString ++ " " ++ tail.all()
  }

  override def add[B >: A](msg: B): LogList[B] = new Log[B](msg, this)

}

object Empty extends LogList[Nothing] {

  override def last(): Nothing = throw new NoSuchElementException()

  override def previous(): LogList[Nothing] = throw new NoSuchElementException()

  override def isEmpty: Boolean = true

  override def all(): String = ""

  override def add[A](msg: A): LogList[A] = new Log(msg, Empty)
}