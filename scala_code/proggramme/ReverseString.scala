package com.proggramme
import scala.collection.mutable._
object ReverseString extends App {
  val st = "jitendra"
  val stack: Stack[Char] = Stack()
  st.map(stack.push)
  println(stack.mkString)
}
