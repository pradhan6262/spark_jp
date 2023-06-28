package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object simpleagg extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession
    .builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val df = spark.read.option("header", "true")
    .csv("C:\\Work\\dataset\\order_data.csv")
  df.select(count("*").as("total_cnt")
    , sum("Quantity").as("total_sum")
    , avg("UnitPrice").as("avg_unit_price")
    , countDistinct("InvoiceNo").as("distinctCount")
  ).show()
  println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
  df.selectExpr("count(*) as total_cnt"
    ,"sum(Quantity) as total_sum"
    ,"avg(UnitPrice) as avg_unit_price"
    ,"count(distinct(InvoiceNo)) as distinctCount"
  ).show()
}
