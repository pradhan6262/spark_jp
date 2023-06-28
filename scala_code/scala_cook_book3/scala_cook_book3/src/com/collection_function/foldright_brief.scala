package com.collection_function

object foldright_brief extends App {
  val persons = List(Person("Thomas", "male"), Person("Sowell", "male"), Person("Liz", "female"))
  val op = persons.foldRight(List[String]()) {
    (person, accumaltor) =>
      val title = person.gender match {
        case "male" => "Mr"
        case "female" => "Mrs"
      }
      accumaltor :+ s"$title ${person.name}"
  }
  println(op)
}
