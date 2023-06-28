package com.proggramme

import scala.collection.mutable._

object NextGreaterElementToRight extends App {
  val arr = Array(2, 7, 3, 4, 8, 1)
  println(arr.mkString(","))
  println(nextGreaterElement(arr).mkString(","))

  def nextGreaterElement(arr: Array[Int]): Array[Int] = {
    val n = arr.length
    val result = new Array[Int](n)
    val stack: Stack[Int] = Stack()
    for (i <- 0 until n reverse) {
      if (!stack.isEmpty) {
        while (!stack.isEmpty && stack.top <= arr(i))
          stack.pop()
      }
      if (stack.isEmpty)
        result(i) = -1
      else
        result(i) = stack.top
      stack.push(arr(i))
    }
    result
  }
}
