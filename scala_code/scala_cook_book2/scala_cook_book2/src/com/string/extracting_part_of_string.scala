package com.string

object extracting_part_of_string extends App {
  val pattern = "([0-9]+) ([A-Za-z]+)".r
  val pattern(count, fruit) = "100 Bananas"
  println(count)
  println(fruit)

}
