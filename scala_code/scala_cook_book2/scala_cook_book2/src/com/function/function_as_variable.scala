package com.function

object function_as_variable extends App {
  val double = (i: Int) => i * 2
  val lst = List.range(1, 10)
  println(lst)
  println(lst.map(double))
}
