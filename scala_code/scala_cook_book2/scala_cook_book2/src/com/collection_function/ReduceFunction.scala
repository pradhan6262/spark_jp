package com.collection_function

object ReduceFunction extends App {
  val list = (1 to 10).toList
  val op = list.reduceLeft(_-_)
  println(op)
}
