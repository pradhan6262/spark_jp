package com.info


import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object broadcastjoinex extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val orders_df = spark.read.option("header", "true")
    .csv("C:\\Work\\dataset\\orders.txt")
  val customer_df = spark.read.option("header", "true")
    .csv("C:\\Work\\dataset\\customers.csv")
  val join_expr = orders_df.col("order_customer_id") === customer_df.col("customer_id")
  val join_type = "INNER"
  val op = orders_df.join(broadcast(customer_df), join_expr, join_type)
  op.show()
}
