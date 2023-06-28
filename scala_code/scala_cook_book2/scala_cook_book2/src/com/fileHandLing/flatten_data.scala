package com.fileHandLing

import scala.io.Source

object flatten_data extends App {
  val files = Source.fromFile("C:\\Work\\dataset\\file_data.txt")
  val lines = files.getLines.toList
  val op = lines.flatMap(x => x.split(" ").toList).toSet
  println(op)
}
