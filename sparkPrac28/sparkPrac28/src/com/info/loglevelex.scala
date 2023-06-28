package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object loglevelex extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", this.getClass.getName)
  val input = sc.textFile("C:\\Work\\dataset\\log.txt")
  val op = input.map(x => (x.split(":")(0), 1)).reduceByKey(_ + _)
  op.collect.foreach(println)
}
