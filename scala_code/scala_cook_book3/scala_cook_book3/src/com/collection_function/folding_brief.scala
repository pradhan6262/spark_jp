package com.collection_function

case class Person(name: String, gender: String)

object folding_brief extends App {
  val persons = List(Person("Thomas", "male"), Person("Sowell", "male"), Person("Liz", "female"))
  val op=persons.foldLeft(List[String]()) { (accumulator, person) =>
    val title = person.gender match {
      case "male" => "Mr"
      case "female" => "Mrs"
    }
    accumulator :+ s"$title ${person.name}"
  }
  println(op)

}
