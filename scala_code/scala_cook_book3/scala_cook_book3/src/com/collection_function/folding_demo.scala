package com.collection_function

object folding_demo extends App {
  val num_list = List(1, 2, 3, 4, 5)
  val op = num_list.foldLeft(0)(_ + _)
  println(op)
}
