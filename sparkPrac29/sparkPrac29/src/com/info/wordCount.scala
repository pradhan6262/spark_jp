package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object wordCount extends App
{
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", this.getClass.getName)
  val input = sc.textFile("C:\\Work\\dataset\\search.txt")
  val op = input.flatMap(x => x.split(" ")).
    map(x => (x, 1)).reduceByKey((x, y) => x + y).sortBy(x => x._2, false)
  op.take(10).foreach(println)
}
