package com.proggramme

object BinarySearch extends App {
  val arr = Array(3, 2, 4, 7, 10, 6, 5)
  println(search(arr, 7))

  def search(arr: Array[Int], key: Int): Int = {
    var start = 0
    var end = arr.length - 1
    while (start < end) {
      val mid = (start + end) / 2
      if (arr(mid) == key) {
        return mid
      }
      else if (key < arr(mid))
        end = mid - 1
      else
        start = mid + 1
    }
    -1
  }
}
