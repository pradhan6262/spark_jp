package com.circularSinglyLinked.list

class Listnode(nodedata: Int) {
  var data = nodedata
  var next: Listnode = null
}

class CircularSinglyLinkedList {
  var last: Listnode = null
  var length = 0

  def isEmpty(): Boolean = {
    this.length == 0
  }

  def getLength(): Int = {
    this.length
  }

  def createCircularSinglyLinkedList() = {
    val first = new Listnode(10)
    val second = new Listnode(20)
    val third = new Listnode(30)
    val fourth = new Listnode(40)
    first.next = second
    second.next = third
    third.next = fourth
    fourth.next = first
    last = fourth
  }

  def display(): Unit = {
    if (last == null)
      return
    var first = last.next
    while (first != last) {
      print(first.data + " ")
      first = first.next
    }
    println(last.data)
  }

  def insertFirst(data: Int) = {
    val temp = new Listnode(data)
    if (isEmpty) {
      last = temp
    }
    else {
      temp.next = last.next
    }
    last.next = temp
    length += 1
  }

  def insertLast(data: Int) = {
    val temp = new Listnode(data)
    if (isEmpty) {
      last = temp
      last.next = last
    }
    else {
      temp.next = last.next
      last.next = temp
      last = temp
    }
    length += 1
  }

  def deleteFirst(): Listnode = {
    if (isEmpty)
      throw new NoSuchElementException("there is no element !!!")
    val temp = last.next
    if (temp == last)
      last = null
    else
      last.next = temp.next
    temp.next = null
    length -= 1
    temp
  }
}


object circularSinglyLinkedListMain extends App {
  val cil = new CircularSinglyLinkedList
  cil.insertLast(10)
  cil.insertLast(20)
  cil.insertLast(30)
  cil.insertLast(40)
  cil.deleteFirst()
  cil.display()
}
