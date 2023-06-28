package com.control

object for_comprehension extends App {
  val names = Array("chris", "ed", "maurice")
  val capName = for (e <- names) yield e.capitalize
  println(capName)
  var fruits = scala.collection.mutable.ArrayBuffer[String]()
  fruits += "apple"
  fruits += "banana"
  fruits += "orange"
  println(fruits)
}
