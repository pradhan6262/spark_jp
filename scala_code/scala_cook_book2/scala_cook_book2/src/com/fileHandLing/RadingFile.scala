package com.fileHandLing

import java.io.FileNotFoundException
import scala.io.Source


object RadingFile extends App {
  val filename = "C:\\Work\\dataset\\sampledata.txt"
  for (line <- Source.fromFile(filename).getLines) {
    println(line)
  }
  val lines = Source.fromFile("C:\\Work\\dataset\\sampledata.txt").getLines.toList
  println(lines)

  /**
   * closing a file
   */
  val bufferdSource = Source.fromFile("C:\\Work\\dataset\\sampledata.txt")
  for (line <- bufferdSource.getLines)
    println(line.toUpperCase)
  bufferdSource.close()

  /**
   * Handling Exception
   */
  val file_name = "no-such-filename"
  try {
    for (line <- Source.fromFile(file_name).getLines)
      println(line)
  }
  catch {
    case e: FileNotFoundException => println("could not found that file")
    case e: Exception => println("Got an IO exception")
  }
}
