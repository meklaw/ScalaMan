package ru.meklaw
package exercises.week1

import scala.annotation.tailrec

sealed abstract class LogList {
  def last(): String

  def previous(): LogList

  def isEmpty: Boolean

  def all(): String

  def add(msg: String): LogList
}

class Log(head: String, tail: LogList) extends LogList {
  override def last(): String = head

  override def previous(): LogList = tail

  override def isEmpty: Boolean = false

  override def all(): String = {
    @tailrec
    def loop(item: LogList = this, accumulator: String = ""): String = {
      if (item == Empty) accumulator
      else {
        loop(item.previous(), accumulator ++ item.last() ++ " ")
      }
    }

    loop()
  }

  override def add(msg: String): LogList = new Log(msg, this)

}

object Empty extends LogList {

  override def last(): String = throw new NoSuchElementException()

  override def previous(): LogList = throw new NoSuchElementException()

  override def isEmpty: Boolean = true

  override def all(): String = ""

  override def add(msg: String): LogList = new Log(msg, Empty)
}