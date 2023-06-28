package com.proggramme

object RemoveEvenInteger extends App {
  val arr = Array(3, 2, 4, 7, 10, 6, 5)
  val op = arr.filter(x => x % 2 != 0)
  println(op.mkString(","))
}
