package com.doublyLinked.list

class Listnode(nodedata: Int) {
  var data = nodedata
  var next: Listnode = null
  var previous: Listnode = null
}

class DoublyLikedList {
  var head: Listnode = null
  var tail: Listnode = null
  var length: Int = 0

  def isEmpty(): Boolean = {
    this.length == 0
  }

  def getLength(): Int = {
    this.length
  }

  def insertFirst(data: Int) = {
    val node = new Listnode(data)
    if (isEmpty) {
      tail = node
    }
    else {
      head.previous = node
    }
    node.next = head
    head = node
    length += 1
  }

  def insertLast(data: Int): Unit = {
    val node = new Listnode(data)
    if (isEmpty) {
      head = node
    }
    else {
      tail.next = node
    }
    node.previous = tail
    tail = node
    length += 1
  }

  def displayForward(): Unit = {
    var current = head
    while (current != null) {
      print(current.data + "-->")
      current = current.next
    }
    println("null")
  }

  def displayBackWord(): Unit = {
    var temp = tail
    while (temp != null) {
      print(temp.data + "-->")
      temp = temp.previous
    }
    println("null")
  }

  def deleteFirst(): Listnode = {
    if (isEmpty)
      throw new NoSuchElementException("there is no element !!!")
    val temp = head
    if (head == tail)
      tail.next = null
    else {
      head.next.previous = null
    }
    head = head.next
    temp.next = null
    length -= 1
    temp
  }

  def deleteLast() =
  {
    if (isEmpty) {
      throw new NoSuchElementException("there is no element !!!")
    }
    val temp = tail
    if (head == tail)
      head = null
    else {
      tail.previous.next = null
    }
    tail = tail.previous
    temp.previous = null
    length -= 1
  }
}

object doublyLinkedListMain extends App {
  val dil = new DoublyLikedList
  dil.insertLast(10)
  dil.insertLast(20)
  dil.insertLast(30)
  dil.insertLast(40)
  dil.deleteLast
  dil.displayForward
  dil.displayBackWord
}
