package com.fileHandLing

import scala.io.Source

object csv_data extends App {
  val file = Source.fromFile("C:\\Work\\dataset\\demo.txt")
  val lines = file.getLines().toList
  for (line <- lines) {
    val Array(month, revenue, expenses, profit) = line.split(",").map(_.trim)
    println(s"$month $revenue $expenses $profit")
  }

}
