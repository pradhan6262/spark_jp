package com.proggramme

object ProductOFArr extends App {
  val arr = Array(1, 2, 3, 4)
  val op = productOfArr(arr)
  println(op.mkString(","))

  def productOfArr(arr: Array[Int]): Array[Int] = {
    var temp = 1
    val n = arr.length
    val result = new Array[Int](n)
    for (i <- 0 until n) {
      result(i) = temp
      temp = arr(i) * temp
    }
    temp = 1
    for (i <- 0 until n reverse) {
      result(i) = temp * result(i)
      temp = temp * arr(i)
    }
    result
  }
}