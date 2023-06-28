package com.string

object splitting_string extends App
{
  var s = "eggs, milk, butter, Coco Puffs"
  s.split(",").map(x=>x.trim).foreach(println)
}
