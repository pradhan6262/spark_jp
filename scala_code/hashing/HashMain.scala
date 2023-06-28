package com.hashing

import scala.util.control.Breaks.{break, breakable}


class HashNode(hashKey: Int, hashValue: String) {
  var key = hashKey
  var value = hashValue
  var next: HashNode = _
}

class HashTable(capacity: Int) {
  var buckets = new Array[HashNode](capacity)
  var noOfBucket = capacity
  var size = 0

  def isEmpty(): Boolean = {
    this.size == 0
  }

  def getLength(): Int = {
    this.size
  }

  def getBucketIndex(key: Int): Int = {
    key % noOfBucket
  }

  def put(key: Int, value: String): Unit = {
    val bucketIndex = getBucketIndex(key)
    var head = buckets(bucketIndex)
    while (head != null) {
      if (head.key == key) {
        head.value = value
        return
      }
      head = head.next
    }
    size += 1
    head = buckets(bucketIndex)
    val node = new HashNode(key, value)
    node.next = head
    buckets(bucketIndex) = node
  }

  def get(key: Int): String = {
    val bucketIndex = getBucketIndex(key)
    var head = buckets(bucketIndex)
    while (head != null) {
      if (head.key == key)
        return head.value
      head = head.next
    }
    null
  }

  def delete(key: Int): Unit = {
    val bucketIndex = getBucketIndex(key)
    var previous: HashNode = null
    var head = buckets(bucketIndex)
    breakable {
      while (head != null) {
        if (head.key == key) {
          break
        }
        previous = head
        head = head.next
      }
    }
    if (head == null)
      return
    size -= 1
    if (previous == null)
      buckets(bucketIndex) = head.next
    else
      previous.next = head.next
  }
}

object HashMain extends App {
  val table = new HashTable(10)
  table.put(105, "Tom")
  table.put(21, "Sana")
  table.put(21, "Harry")
  table.put(31, "Dinesh")
  table.delete(21)
  println(table.size)
}
