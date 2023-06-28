package com.proggramme

object InsertPos extends App {
  val arr = Array(1, 10, 20, 47, 59, 65, 75, 88, 99)
  println(insertPos(arr,66))
  def insertPos(arr: Array[Int], key: Int): Int = {
    var start = 0
    var end = arr.length - 1
    while (start <= end) {
      val mid = start + (end - start) / 2
      if (arr(mid) == key)
        return mid
      else if (key < arr(mid))
        end = mid - 1
      else
        start = mid + 1
    }
    start
  }
}
