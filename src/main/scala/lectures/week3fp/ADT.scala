package ru.meklaw
package lectures.week3fp

object ADT {
  def main(args: Array[String]): Unit = {
    //    Алгебраические типы данных (АТД ) / Algebraic Data Types (ADT)
    //    1 Sum ADT (тип суммы)
    //    можем перечислить
    sealed trait WeekDay
    case object Mon extends WeekDay
    case object Tue extends WeekDay
    case object Wed extends WeekDay
    case object Thu extends WeekDay
    case object Fri extends WeekDay
    case object Sun extends WeekDay
    case object Sat extends WeekDay

    val day: WeekDay = Mon
    println(s"Today is $day") // Today is Mon

    //    2 Product ADT (тип произведения)
    //    нельзя сделать для каждого значения конструктор
    sealed case class RGB(red: Int, green: Int, blue: Int)

    val whiteRGB = RGB(255, 255, 255)
    println(s"White: $whiteRGB") // White: RGB(255,255,255)

    //    3 Hybrid ADT (гибридный тип)
    //    объединение первых двух типов
    sealed trait Platform
    case class IOS(appId: String) extends Platform
    case class Android(packageId: String, sha1Cert: String) extends Platform
    //    работа идет с платформой iOS или Android ("или" указывает на Sum ADT);
    //    Product ADT был задействован при описании того же Android т.к. пришлось создавать универсальный конструктор,
    //    учитывающий различные значения для packageId и sha1Cert.

    //    Довольно часто АТД используются с шаблонами. Это позволяет сделать код более чистым и легким для чтения
    object Platform {
      def offer(platform: Platform): String =
        platform match {
          case IOS(_) => "offer for ios"
          case Android(_, _) => "offer for android"
          case _ => "default offer"
        }
    }

    val platform: Platform = IOS("A1B2C3D4E5")
    println(s"your offer is ${Platform.offer(platform)}")

  }
}
