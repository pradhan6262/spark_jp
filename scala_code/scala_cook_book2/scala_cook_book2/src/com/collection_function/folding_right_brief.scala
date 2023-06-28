package com.collection_function

object folding_right_brief extends App {
  val persons = List(Person("Thomas", "male"), Person("Sowell", "male"), Person("Liz", "female"))
  val op=persons.foldRight(List[String]()) { (person, accumulator) =>
    val title = person.sex match {
      case "male" => "Mr."
      case "female" => "Mrs."
    }
    accumulator :+ s"$title ${person.name}"
  }
  println(op)
}
