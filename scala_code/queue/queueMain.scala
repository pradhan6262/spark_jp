package com.queue

class Listnode(nodedata: Int) {
  var data = nodedata
  var next: Listnode = null
}

class queue {
  var front: Listnode = null
  var rear: Listnode = null
  var length = 0

  def isEmpty(): Boolean = {
    this.length == 0
  }

  def getLength(): Int = {
    this.length
  }

  def enqueue(data: Int) = {
    val temp = new Listnode(data)
    if (isEmpty)
      front = temp
    else
      rear.next = temp
    rear = temp
    length += 1
  }

  def dequeue(): Unit = {
    if (isEmpty())
      throw new NoSuchElementException("there is no element !!!")
    val temp = front
    front = front.next
    if (temp == rear)
      rear = null
    temp.next = null
    length -= 1
  }

  def display() = {
    var current = front
    while (current != null) {
      print(current.data + "-->")
      current = current.next
    }
    println("null")
  }
}


object queueMain extends App {
  val queue = new queue
  queue.enqueue(10)
  queue.enqueue(20)
  queue.enqueue(30)
  queue.enqueue(40)
  queue.dequeue
  queue.display
}
