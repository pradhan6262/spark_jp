package com.string

object string_util extends App {
  val st = "HAL"
  val op = st.map(x => (x + 1).toChar)
  println(op)
}
