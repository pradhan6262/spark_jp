package com.proggramme

object LinearSearch extends App {
  val arr = Array(3, 2, 4, 7, 10, 6, 5)
  println(search(arr, 7))
  def search(arr: Array[Int], key: Int): Int = {
    for (i <- 0 until arr.length if key == arr(i))
      return i
    -1
  }
}
