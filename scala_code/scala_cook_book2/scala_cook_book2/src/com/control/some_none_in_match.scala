package com.control

object some_none_in_match extends App {
  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    }
    catch {
      case e: Exception => None
    }
  }

  toInt("rubbish") match {
    case Some(a) => println(a)
    case _ => println("what to you want.....")
  }

}
