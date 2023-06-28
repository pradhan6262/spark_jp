package com.proggramme

import scala.collection.mutable._

object firstNonRepeatingChar extends App {
  val st = "racecars"
  println(firstNonReapeatingChar(st))
  def firstNonReapeatingChar(st: String): Any = {
    val map: HashMap[Char, Int] = HashMap()
    for (ch <- st) {
      map.put(ch, map.getOrElse(ch, 0) + 1)
    }
    for (ch <- st if (map(ch) == 1))
      return ch
    null
  }
}
