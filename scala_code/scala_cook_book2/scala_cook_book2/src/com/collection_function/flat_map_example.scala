package com.collection_function

object flat_map_example extends App {
  val list = List(2, 3, 4)

  def f(x: Int) = List(x - 1, x, x + 1)

  val res = list.flatMap(f)
  println(res)

}
