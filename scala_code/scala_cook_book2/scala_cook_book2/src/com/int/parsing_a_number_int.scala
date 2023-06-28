package com.int

object parsing_a_number_int extends App {
  println("100".toInt)
  println(Integer.parseInt("100", 2))

  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    }
    catch {
      case e: Exception => None
    }
  }

  val op = toInt("abv") match {
    case Some(x) => x
    case _ => 0
  }
  println(op)
}
