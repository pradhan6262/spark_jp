package com.proggramme


import scala.collection.mutable._

object TwoSumHashMap extends App {
  var arr = Array(2, 11, 5, 10, 7, 8)
  twoSum(arr, 9)

  def twoSum(arr: Array[Int], target: Int) = {
    val map: HashMap[Int, Int] = HashMap()
    for (i <- 0 until arr.length) {
      if (!map.contains(target - arr(i))) {
        map.put(arr(i), i)
      }
      else {
        println(map(target - arr(i)) + "," + i)
      }
    }
  }
}
