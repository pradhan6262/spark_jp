package com.proggramme

object ThreeSum extends App {
  val arr = Array(2, 4, 3, 7, 1, 8, 9, 0)
  threeSum(arr, 6)

  def threeSum(ar: Array[Int], target: Int) = {
    val arr = ar.sorted
    val n = arr.length
    for (i <- 0 until n) {
      var j = i + 1
      var k = n - 1
      while (j < k) {
        val sum = arr(i) + arr(j) + arr(k)
        if (sum == target) {
          println(arr(i) + "," + arr(j) + "," + arr(k))
          j += 1
          k -= 1
        }
        else if (sum < target)
          j += 1
        else
          k -= 1
      }
    }
  }
}
