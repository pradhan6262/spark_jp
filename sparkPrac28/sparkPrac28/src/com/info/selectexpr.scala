package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, expr}

object selectexpr extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .master("local[*]")
    .appName(this.getClass.getName)
    .getOrCreate
  val df = spark
    .read
    .option("header", "true")
    .csv("C:\\Work\\dataset\\orders.txt")
  df.select(col("order_id")
    , col("order_customer_id")
    , expr("concat(order_status,'_STATUS')").as("order_status")
  ).show()
  println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
  df.selectExpr("order_id"
    , "order_customer_id"
    , "concat(order_status,'_STATUS') as order_status"
  ).show()
}
