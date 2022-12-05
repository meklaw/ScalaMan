package ru.meklaw
package lectures.week3fp

object PartialFunctions {
  def main(args: Array[String]): Unit = {
    val whatToDo = (d: String) => d match {
      case "mon" => "Work!"
      case "fri" => "Party Time"
      case "sun" => "Relax a little"
    }

    //    С помощью частичной функции можно записать так
    //    1 тип, который получает. 2 тип, который возвращает
    val aPartialFunction: PartialFunction[String, String] = {
      case "mon" => "Work!"
      case "fri" => "Party Time"
      case "sun" => "Relax a little"
    }

    //    в обоих случаях в результате несовпадения будет ошибка MatchError
    //    для избежания ошибки доступен следующий метод isDefinedAt
    println(aPartialFunction.isDefinedAt("tue")) // false

    //    orElse позволяет объединить функции
    //    вызываются значения сначала для aPartialFunction, а потом уже иначе для pfChain
    val pfChain: PartialFunction[String, String] = aPartialFunction.orElse[String, String] {
      case "sat" => "It's just Saturday"
      case "sun" => "Sunny"
    }

    println(pfChain("mon")) //Work!
    println(pfChain("sat")) //It's just Saturday
    println(pfChain("sun")) //Relax a little

    //    лифтинг - поднимает функцию на следующий уровень, и она начинает возвращать тип Option
    //    (т.е. решается проблема MatchError)
    val lifted = aPartialFunction.lift

    println(lifted("fri")) //Some(Party Time)
    println(lifted("frifasdf")) //None
  }
}
