package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


object structuredapiex extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession
    .builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val df = spark.read.option("header","true").csv("C:\\Work\\dataset\\orders.txt")
  df.filter(col("order_customer_id") > 10000).show
}
