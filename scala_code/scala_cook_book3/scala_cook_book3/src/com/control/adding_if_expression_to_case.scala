package com.control

object adding_if_expression_to_case extends App {
  val i = 29
  i match {
    case a if 0 to 9 contains (a) => println("in the range 0 to 9")
    case b if 10 to 19 contains (b) => println("in the range 10 to 19")
    case c if 11 to 29 contains (c) => println("in the range 20 to 29")
    case _ => println("some other range !!!")
  }
  val num = 3
  num match {
    case x if x == 1 => println("one, a lonely number")
    case x if x == 2 || x == 3 => println(x)
    case _ => println("some other number !!!")
  }

}
