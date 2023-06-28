package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{ SparkContext}

object avgcal extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", this.getClass.getName)
  val input = sc.textFile("C:\\Work\\dataset\\friendsdata.csv")
  val op = input.map(x => (x.split(",")(2), x.split(",")(3).toInt)).
    mapValues(x => (x, 1)).
    reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2)).
    mapValues(x => x._1 / x._2).sortBy(x => x._2, false)
  op.take(10).foreach(println)
}
