package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, unix_timestamp}
import org.apache.spark.sql.types.DateType

object castexample extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession
    .builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val mylist = List((1, "2013-07-25", 11599, "CLOSED"),
    (2, "2013-08-25", 11599, "PENDING_PAYMENT"),
    (3, "2013-09-25", 12111, "COMPLETE"),
    (4, "2013-10-25", 8827, "CLOSED"),
    (5, "2013-11-25", 11318, "COMPLETE"))
  val df = spark.createDataFrame(mylist)
    .toDF("id", "orders_date", "order_customer_id", "order_status")
  df.withColumn("orders_date"
    , unix_timestamp(col("orders_date").cast(DateType))).show()
}
