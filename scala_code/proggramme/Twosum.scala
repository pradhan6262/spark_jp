package com.proggramme

object Twosum extends App {
  val arr = Array(2, 11, 5, 10, 7, 8)
  twoSum(arr, 15)

  def twoSum(ar: Array[Int], target: Int) = {
    val arr = ar.sorted
    var left = 0
    var right = arr.length - 1
    while (left < right) {
      val sum = arr(left) + arr(right)
      if (sum == target) {
        println(arr(left) + "," + arr(right))
        left += 1
        right -= 1
      }
      else if (sum < target)
        left += 1
      else
        right -= 1
    }
  }
}
