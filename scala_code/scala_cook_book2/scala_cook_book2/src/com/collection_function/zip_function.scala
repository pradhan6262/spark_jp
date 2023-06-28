package com.collection_function

object zip_function extends App {
  val a = List(1, 2, 3, 4)
  val b = List(3, 4, 5)
  val c = a.zip(b)
  val res = c.map {
    case (x, y) => x + y
  }
  println(res)
  val un_zip=c.unzip
  println(un_zip)
}
