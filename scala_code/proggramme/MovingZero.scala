package com.proggramme

object MovingZero extends App {
  val arr = Array(10, 20, 0, 50, 0, 30, 40)
  movingZero(arr)
  println(arr.mkString(","))
  def movingZero(arr: Array[Int]) = {
    var j = 0
    for (i <- 0 until arr.length) {
      if (arr(i) != 0 && arr(j) == 0) {
        val temp = arr(i)
        arr(i) = arr(j)
        arr(j) = temp
      }
      if (arr(j) != 0)
        j += 1
    }
  }
}
