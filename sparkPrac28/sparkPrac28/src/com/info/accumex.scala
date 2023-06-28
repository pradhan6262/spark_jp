package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object accumex extends App
{
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", this.getClass.getName)
  val accume = sc.longAccumulator("empty line accumulator !!!")
  val input = sc.textFile("C:\\Work\\dataset\\sampledata.txt")
  input.foreach(x => if (x == "") accume.add(1))
  println(accume)
}
