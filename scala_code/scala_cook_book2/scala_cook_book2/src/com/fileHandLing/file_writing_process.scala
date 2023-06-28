package com.fileHandLing

import java.io.{File, FileWriter, PrintWriter}

object file_writing_process extends App {
  val pw = new FileWriter(new File("hello.txt"), true)
  for (i <- 0 to 4) {
    pw.write(s"pello,World\n")
  }
  pw.close()
}
