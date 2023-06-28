package com.control

object looping_with_for extends App {
  val a = Array("apple", "banana", "orange")
  for (e <- a)
    println(e)
  val newArr = for (e <- a) yield e.toUpperCase
  println(newArr.mkString(","))
  for ((e, count) <- a.zipWithIndex) {
    println(s"$count,$e")
  }

  /**
   * for with condition statement
   */
  for (i <- 1 to 10 if i != 4)
    println(i)

  /**
   * Looping of map
   */
  val names = Map("fname" -> "Robert", "lname" -> "doweny jr ")
  for ((k, v) <- names)
    println(s"key:$k,value:$v")
  println("abc")
  a.foreach(println)
  a.foreach(e=>println(e.toUpperCase))
}
