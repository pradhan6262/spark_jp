package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

import scala.io.Source

object broadcastex extends App {
  val boringWordSet: Set[String] = {
    var boring = Set[String]()
    val lines = Source.fromFile("C:\\Work\\dataset\\boringwordset.txt").getLines.toList
    lines.map(x => boring += x)
    boring
  }

  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", this.getClass.getName)
  val input = sc.textFile("C:\\Work\\dataset\\bigdatacampaigndata.csv")
  val broadcast = sc.broadcast(boringWordSet)
  val op = input.map(x => (x.split(",")(10).toFloat, x.split(",")(0)))
    .flatMapValues(x => x.split(" ")).map(x => (x._2.toLowerCase, x._1))
    .filter(x => broadcast.value(x._1)).reduceByKey(_ + _).sortBy(_._2, false)
  op.take(20).foreach(println)
}
