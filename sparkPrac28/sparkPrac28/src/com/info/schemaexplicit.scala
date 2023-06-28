package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType, TimestampType}

object schemaexplicit extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val schema = StructType(List(
    StructField("order_id", IntegerType),
    StructField("order_date", TimestampType),
    StructField("order_customer_id", IntegerType),
    StructField("order_status", StringType)
  ))
  val df = spark.read.schema(schema).option("header", "true")
    .csv("C:\\Work\\dataset\\orders.txt")
  df.show()
}
