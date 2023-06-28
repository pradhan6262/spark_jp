package com.control

object looping_with_for extends App {
  val a = Array("apple", "banana", "orange")
  val newArr = for (e <- a) yield e.toUpperCase
  println(newArr.mkString(","))
  for ((e, count) <- a.zipWithIndex)
    println(s"$count:$e")
  val names=Map("fname"->"robbert","lname"->"downey jr")
  for((k,v)<-names)
    println(s"key:$k,value:$v")
}
