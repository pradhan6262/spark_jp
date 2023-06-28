package com.string

object pattern_string extends App {
  val numPatern = "[0-9]+".r
  var address = "123 Main2 Street Suite 101"
  var op = numPatern.findAllIn(address).toList
  println(op)
  val res = numPatern.findFirstIn(address).getOrElse("124")
  println(res)

}
