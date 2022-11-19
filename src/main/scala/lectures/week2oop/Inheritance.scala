package ru.meklaw
package lectures.week2oop

object Inheritance {
  def main(args: Array[String]): Unit = {
    /*protected работает немного по другому,
     делая отмеченные поля и методы доступными для класса и его подкласса, но недоступными вне их тел

     override помогает переопределить методы и переменные класса
     представляет иное поведение, но имеет идентичную с методом родительского класса сигнатуру
     тип возвращаемого значения обязательно должен быть такой же, как у метода, описанного в родительском классе
     остальное перегрузка !

     super позволяет вызывать методы и переменные родителя

     final
     1 члены класса - запрещает override
     2 класс - запрещает наследование

     sealed для класса, как final
     запрещает наследование ВНЕ текущего файла
     можно сравнить с enum из ДЖАВЫ

     abstract class BaseDataSource(ds: String) {
     val user: String
     def connect: String
     }
     анонимный класс
     val someSource = new BaseDataSource("someDS") {
       override val user: String = "someSourceUser"
       override def connect: String = "someSource connection"
     }


    trait
    похожи на абстрактные классы, но:
    - не могут задаваться с параметрами
    - можно указать несколько трейтов для одного класса
    - трейты описывают поведение для конкретной ситуации

    trait Callable
    trait PhotoMaker
    class phone extends Callable with PhotoMaker

     */
  }
}

class Button(val label: String = "test") {
  def click(): String = {
    s"button -$label- has been clicked"
  }
}

class RoundedButton(override val label: String) extends Button(label) {
  override def click(): String = {
    "rounded " ++ super.click()
  }
}

trait Device {
  def processDoc: Unit
}

trait Printer extends Device {
  override def processDoc: Unit = println("print your txt")
}

trait Scanner extends Device {
  override def processDoc: Unit = println("scan your txt")
}

class ComboDevice extends Printer with Scanner
/*
* при вызове
* val device = new ComboDevice
* device.processDoc
*
* выберет самую последнюю реализацию processDoc
* а именно Scanner
* */