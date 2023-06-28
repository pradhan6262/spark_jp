package com.control

object factorial_tail_recursion extends App {
  def factorial(n: Int): Int = {
    def factorial(num: Int, result: Int): Int = {
      if (num == 1) result
      else factorial(num - 1, result * num)
    }

    factorial(n, 1)
  }
  println(factorial(5))

}
