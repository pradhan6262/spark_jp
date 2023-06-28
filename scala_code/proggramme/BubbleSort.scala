package com.proggramme

import scala.util.control.Breaks.{break, breakable}

object BubbleSort extends App {
  val arr = Array(3, 2, 4, 7, 10, 6, 5)
  sort(arr)
  println(arr.mkString(","))

  def sort(arr: Array[Int]) = {
    val n = arr.length
    var isSwapped = false
    breakable {
      for (i <- 0 until n - 1) {
        for (j <- 0 until n - 1 - i) {
          if (arr(j) > arr(j + 1)) {
            val temp = arr(j)
            arr(j) = arr(j + 1)
            arr(j + 1) = temp
            isSwapped = true
          }
          if (isSwapped == false)
            break
        }
      }
    }
  }
}
