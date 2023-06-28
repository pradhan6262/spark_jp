package com.proggramme
import scala.collection.mutable._
object ArrayReverse extends App
{
  val arr=Array(3, 2, 4, 7, 10, 6, 5)
  val stack:Stack[Int]=Stack()
  arr.map(stack.push)
  println(stack.mkString(","))
}
