package ru.meklaw
package lectures.week2oop

object ClassesOOP extends App {
  /*a - Параметр конструктора  (параметр)
  * b - Параметр конструктора  (параметр)
  * c - поле класса*/
  /*
  когда мы пишем class Pizza private{...}
  у нас создается приватный дефолтный конструктор и
  поэтому мы не можем создавать объект new Pizza*/

  class SomeClass(a: Int, b: Int, val c: Int) {
    def this() = this(0, 0, 0)

    def this(a: Int, b: Int) = this(a, b, 0)

    def someFunc(): Int = b
  }

  val instructor: Instructor = new Instructor(1, "вася", "пупкин")
  println(instructor.fullName()) // Вася Пупкин

  val course: Course = new Course(2, "Course Name", "1234", instructor)
  println(course.instructor.fullName())    // Вася Пупкин
  println(course.getID)    // 21
  println(course.isTaughtBy(instructor))    // true
  println(course.isTaughtBy(new Instructor(1, "Вася", "Пупкин")))    // false

  println(course.copyCourse("4321").releaseYear)    // 4321
}

class Instructor(val id: Int, val name: String, val surname: String) {
  def fullName(): String = {
    val name = this.name(0).toString.toUpperCase() ++ this.name.substring(1)
    val surname = this.surname(0).toString.toUpperCase() ++ this.surname.substring(1)
    s"$name $surname"
  }
}

class Course(val courseID: Int, val title: String, val releaseYear: String, val instructor: Instructor) {
  def getID(): String = {
    s"${courseID.toString + instructor.id.toString}"
  }

  def isTaughtBy(anotherInstructor: Instructor): Boolean = anotherInstructor == instructor

  def copyCourse(newReleaseYear: String): Course = {
    new Course(courseID, title, newReleaseYear, instructor)
  }
}