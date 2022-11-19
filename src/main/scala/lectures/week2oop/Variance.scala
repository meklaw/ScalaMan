package ru.meklaw
package lectures.week2oop

object Variance {
  def main(args: Array[String]): Unit = {
    /*Инвариантность(Invariance)
    * Ошибка
    * val invFruitList: InvariantList[Fruit] = new InvariantList[Apple]
    *
    * тип, указанный слева, должен совпадать с типом в правой части
    * val invariantFruitList: InvariantList[Fruit] = new InvariantList[Fruit]
    *
    * Контравариантность (Contravariance)
    * val contravariantList: ContravariantList[Apple] = new ContravariantList[Fruit]
    * Пример с фруктами неплохой, но не очень интуитивный
    * class Person[-A]
    * val person: Person[ScalaDeveloper] = new Person[Developer]
    *
    * Представьте ситуацию: вы искали Scala-разработчика к себе в команду, а наняли отличного разработчика,
    * знания которого не ограничены одним лишь языком Scala. Вы ведь от этого только выиграете:
    * у работника больше знаний, больше умений, а значит - больше задач, которые он сможет успешно выполнить.
    *
    * Ковариантность (Covariance)
    * val fruit: Fruit = new Apple
    * val fruitList: CovariantList[Fruit] = new CovariantList[Apple]
    * также если мы добавим Банан
    * fruitList.add(new Banana)
    * то список трансформируется в список фруктов
    *
    * Давайте напишем имплементацию метода add, чтобы точно видеть - какие типы, как и где указывать.
    * class List[+A] {
    * def add[B >: A](element: B): List[B] = ???
    * }
    * Этим кодом мы говорим, что если в список типа A будет добавлен элемент типа B,
    * то список типа A превратится в список типа B, причем B является супер типом для A.
    *
    * */
  }
}

class Fruit

class Apple extends Fruit

class Banana extends Fruit

class InvariantList[A]
class ContravariantList[-A]
class CovariantList[+A]