package com.proggramme

object StringUtil extends App {
  val str = "abcde"
  val seq = "aec"
  println(validSeq(str, seq))

  def validSeq(st: String, seq: String): Boolean = {
    var j = 0
    for (i <- 0 until st.length if st(i) == seq(j))
      j += 1
    seq.length == j
  }
}
