package com.proggramme

import scala.collection.mutable._

object GenerateBinaryNumber extends App {
  generateBinaryNumber(5)
  def generateBinaryNumber(n: Int) = {
    val queue: Queue[String] = Queue()
    queue.enqueue("1")
    for (i <- 0 until n) {
      val n = queue.dequeue()
      print(n+" ")
      queue.enqueue(n + "0")
      queue.enqueue(n + "1")
    }
  }
}
