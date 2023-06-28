package com.singlyLinked.list


class Listnode(nodedata: Int) {
  var data = nodedata
  var next: Listnode = _
}

class SinglyLinkedList {
  var head: Listnode = _

  def insertLast(data: Int): Unit = {
    val node = new Listnode(data)
    if (head == null) {
      head = node
      return
    }
    var current = head
    while (current.next != null) {
      current = current.next
    }
    current.next = node
  }

  def insertSorted(data: Int): Unit = {
    val node = new Listnode(data)
    if (head == null) {
      head = node
      return
    }
    if (data < head.data) {
      node.next = head
      head = node
      return
    }
    var temp: Listnode = null
    var current = head
    while (current != null && current.data <= data) {
      temp = current
      current = current.next
    }
    temp.next = node
    node.next = current
  }

  def deleteKey(key: Int): Unit = {
    if (head == null) {
      throw new NoSuchElementException("there is no element !!!")
    }
    var current = head
    if (current != null && current.data == key) {
      head = head.next
      return
    }
    var temp: Listnode = null
    while (current != null && current.data != key) {
      temp = current
      current = current.next
    }
    temp.next = current.next
  }

  def display() = {
    var current = head
    while (current != null) {
      print(current.data + "-->")
      current = current.next
    }
    println("null")
  }
}

object singlyLinkedListMain extends App {
  val sil = new SinglyLinkedList
  sil.insertSorted(10)
  sil.insertSorted(30)
  sil.insertSorted(40)
  sil.insertSorted(20)
  sil.insertSorted(5)
  sil.deleteKey(40)
  sil.display
}
