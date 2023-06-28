package com.proggramme

object SecondMax extends App {
  val arr = Array(3, 2, 4, 7, 10, 6, 5)
  println(secMax(arr))
  def secMax(arr: Array[Int]): Int = {
    var max = Integer.MIN_VALUE
    var secMax = Integer.MIN_VALUE
    for (ar <- arr) {
      if (ar > max) {
        secMax = max
        max = ar
      }
      else if (ar > secMax && ar != max)
        secMax=ar
    }
    secMax
  }

}
