package com.control

object working_with_list_in_match extends App {
  def listToString(lst: List[String]): String = lst match {
    case s :: rest => s + " " + listToString(rest)
    case Nil => ""
  }

  def sum(lst: List[Int]): Int = lst match {
    case s :: rest => s + sum(rest)
    case Nil => 0
  }

  def multiply(lst: List[Int]): Int = lst match {
    case s :: rest => s * multiply(rest)
    case Nil => 1
  }

  val fruits = List("Apples", "Bananas", "Oranges")
  println(listToString(fruits))
  println(sum(1 to 5 toList))
  println(multiply(1 to 6 toList))

}
