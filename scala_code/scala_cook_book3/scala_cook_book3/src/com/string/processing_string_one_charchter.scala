package com.string

object processing_string_one_charchter extends App {
  var upper = "Hello,World".map(_.toUpper)
  println(upper)
  val filter = "Hello,World".filter(_ != 'l')
  println(filter)
  upper = for (c <- "Hello,World") yield c.toUpper
  println(upper)
  upper = for {
    c <- "Hello,World" if (c != 'l')
  } yield c

}
