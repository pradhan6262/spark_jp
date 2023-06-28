package com.proggramme

object MinValue extends App {
  val arr = Array(3, 2, 4, 7, 10, 6, 5)
  println(minVal(arr))

  def minVal(arr: Array[Int]): Int = {
    var min = arr(0)
    for (i <- 1 until arr.length) {
      if (arr(i) < min)
        min = arr(i)
    }
    min
  }
}
