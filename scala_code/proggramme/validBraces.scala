package com.proggramme

import scala.collection.mutable._

object validBraces extends App {
  val st = "[{()}]"
  println(isValid(st))

  def isValid(st: String): Boolean = {
    val stack: Stack[Char] = Stack()
    for (ch <- st) {
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch)
      }
      if (stack.isEmpty)
        return false
      val top = stack.top
      if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
        stack.pop()
      }
    }
    stack.isEmpty
  }
}
