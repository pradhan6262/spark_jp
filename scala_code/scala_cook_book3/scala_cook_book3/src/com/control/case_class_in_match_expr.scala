package com.control

trait Animal

case class Dog(name: String) extends Animal

case class Cat(name: String) extends Animal

case object Woodpecker extends Animal


object case_class_in_match_expr extends App {
  def determineType(x: Animal) = x match {
    case Dog(moneker) => "got a dog name" + moneker
    case _: Cat => "got a cat ignoring the name"
    case Woodpecker => "got a woodpecker "
    case _ => "this is something else"
  }
  println(determineType(Dog("Rocky")))
  println(determineType(Cat("Rusty the Cat")))
  println(determineType(Woodpecker))
}
