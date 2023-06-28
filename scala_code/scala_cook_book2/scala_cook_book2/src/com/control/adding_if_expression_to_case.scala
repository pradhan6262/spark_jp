package com.control

object adding_if_expression_to_case extends App {
  val i = 31
  i match {
    case a if 0 to 9 contains (a) => println("0-9 range: " + a)
    case b if 10 to 19 contains (b) => println("10 - 19 range" + b)
    case c if 20 to 29 contains (c) => println("20 - 29 range" + c)
    case _ => println("hmm")
  }
  val num = 3
  num match {
    case x if x == 1 => println("one, a lonely number")
    case x if x == 2 || x == 3 => println(x)
    case _ => println("some other value !!!")
  }
}
