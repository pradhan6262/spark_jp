package com.string

object splitting_string extends App
{
  "Hello world".split(" ").foreach(println)

  /**
   * split with trim function
   */
  var s = "eggs, milk, butter, Coco Puffs"
  s.split(",").map(_.trim).foreach(println)
  "hello world, this is Al".split("\\s+").foreach(println)
}
