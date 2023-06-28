package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext


object searchAmount extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", this.getClass.getName)
  val input = sc.textFile("C:\\Work\\dataset\\bigdatacampaigndata.csv")
  val op = input.map(x => (x.split(",")(10).toFloat, x.split(",")(0)))
    .flatMapValues(x=>x.split(" ")).map(x=>(x._2.toLowerCase,x._1))
    .reduceByKey(_+_).sortBy(_._2,false)
  op.take(10).foreach(println)
}
