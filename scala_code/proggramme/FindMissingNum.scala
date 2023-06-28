package com.proggramme

object FindMissingNum extends App {
  val arr = Array(2, 8, 5, 6, 4, 1, 7)
  val n = arr.length + 1
  val sum = n * (n + 1) / 2
  val arr_sum = arr.reduce(_ + _)
  println(sum - arr_sum)

}
