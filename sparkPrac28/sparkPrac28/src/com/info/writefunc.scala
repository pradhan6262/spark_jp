package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{SaveMode, SparkSession}

object writefunc extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val df = spark.read
    .option("header", "true")
    .csv("C:\\Work\\dataset\\orders.txt")
  df.coalesce(1)
    .write
    .mode(SaveMode.Append)
    .csv(".")
  println("Successfully write the data !!!")
}
