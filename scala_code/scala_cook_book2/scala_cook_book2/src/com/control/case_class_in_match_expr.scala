package com.control

trait Animal

case class Dog(name: String) extends Animal

case class Cat(name: String) extends Animal

case object Woodpecker extends Animal

object case_class_in_match_expr extends App {
  def determineType(x: Animal) = x match {
    case Dog(moniker) => "got a Dog, name = " + moniker
    case _: Cat => "got a cat (ignoring the name)"
    case Woodpecker => "that is a woodpecker"
    case _ => "that is something else"
  }
  println(determineType(Dog("Rocky")))
  println(determineType(Cat("Rusty the Cat")))
  println(determineType(Woodpecker))
}
