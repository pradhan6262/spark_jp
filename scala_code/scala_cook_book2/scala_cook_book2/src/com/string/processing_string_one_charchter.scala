package com.string

object processing_string_one_charchter extends App {
  var upper = "hello,world".map(_.toUpper)
  println(upper)
  val filter = "hello,world".filter(_ != 'l')
  println(filter)
  upper = for (c <- "hello,world") yield c.toUpper
  println(upper)
  upper = for {
    c <- "Hello,world" if (c != 'l')
  } yield c.toUpper

}
