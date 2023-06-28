package com.stack

class Listnode(nodedata: Int) {
  var data = nodedata
  var next: Listnode = null
}

class stack {
  var top: Listnode = null
  var length = 0

  def isEmpty(): Boolean = {
    this.length == 0
  }

  def getLength() = {
    this.length
  }

  def push(data: Int): Unit = {
    val temp = new Listnode(data)
    temp.next = top
    top = temp
    length += 1
  }

  def peek(): Int = {
    if (isEmpty())
      throw new NoSuchElementException("there is no element !!!")
    top.data
  }

  def pop(): Int = {
    val temp = top.data
    top = top.next
    temp
  }
}

object stackMain extends App {
  val stack = new stack
  stack.push(10)
  stack.push(20)
  stack.push(30)
  stack.push(40)
  println(stack.peek)
  stack.pop()
  println(stack.peek)
}
