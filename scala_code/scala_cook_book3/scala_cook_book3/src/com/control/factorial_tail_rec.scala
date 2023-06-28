package com.control

object factorial_tail_rec extends App {
  val op=factorial(5)
  println(op)
  def factorial(num: Int):Int = {
    def fact(num: Int, result: Int): Int = {
      if (num == 1) result
      else fact(num - 1, result * num)
    }
    fact(num, 1)
  }

}
