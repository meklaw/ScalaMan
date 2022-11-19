package ru.meklaw
package lectures.week2oop

object Generics {
  def main(args: Array[String]): Unit = {
    def countSum(nums: List[Int]): Int = nums.sum
    def countSum[A: Numeric](nums: List[A]): A = nums.sum
    def count[A](nums: List[A]): Int = nums.size
    /*в качестве обобщенного типа подойдет любая заглавная буква алфавита A, B, C, T, ...
    * обобщения применяются к класса и трейтам, но не к объектам
    *
    * Parking[T <: Vehicle] означает,
    * что в качестве типа T допускается использовать либо непосредственно сам тип Vehicle, либо его подтипы
    *
    * Parking[T >: Vehicle]
    * в качестве Т мы ожидаем либо сам тип Vehicle, либо его супертипы те Thing
    *
    *  class Parking[T >: Bicycle <: Vehicle](val vehicle: T)
    * наша парковка - только для велосипедов
    *  */
  }
}
class SomeClass[T] {
  def someFunc(aVal: T): Unit = println(s"generic type is used")
}