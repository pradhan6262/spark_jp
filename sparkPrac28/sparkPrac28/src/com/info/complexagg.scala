package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object complexagg extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val df = spark
    .read
    .option("header", "true")
    .csv("C:\\Work\\dataset\\order_data.csv")
  df.groupBy("InvoiceNo", "Country")
    .agg(sum("Quantity").as("total_sum"),
      expr("sum(Quantity*UnitPrice)").as("avg_unit_price")
    ).show()
  println("+++++++++++++++++++++++++++++++++++++++++++++++++++++")
  df.groupBy("InvoiceNo", "Country")
    .agg(expr("sum(quantity)").as("total_sum"),
      expr("sum(Quantity*UnitPrice)").as("avg_unit_price")
    ).show()
}
