package com.function

object function_literal extends App {
  val x = List.range(1, 10)
  var evens = x.filter((x: Int) => x % 2 == 0)
  println(evens)
  evens = x.filter(_ % 2 == 0)
  println(evens)
}
