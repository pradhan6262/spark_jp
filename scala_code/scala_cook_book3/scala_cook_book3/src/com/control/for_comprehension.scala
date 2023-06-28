package com.control

import scala.collection.mutable.ArrayBuffer

object for_comprehension extends App {
  val names = Array("chris", "ed", "maurice")
  val capname = names.map(_.capitalize)
  println(capname.mkString(","))
  val fruits = ArrayBuffer[String]()
  fruits += "apple"
  fruits += "banana"
  fruits += "orange"
  println(fruits)
}
