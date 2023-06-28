package com.control

object default_value_match extends App {
  val i = 15
  i match {
    case 0 => println("0")
    case 1 => println("1")
    case jitu => println(jitu)
  }
}
