package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{DateType, IntegerType, StringType, StructField, StructType}

object salarydemo extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val schema = StructType(
    List(
      StructField("id", IntegerType),
      StructField("name", StringType),
      StructField("salary", IntegerType),
      StructField("creditdate", DateType)
    )
  )
  val df = spark.read.
    option("dateFormat", "MM-dd-yyyy").
    schema(schema).
    csv("C:\\Work\\dataset\\salary.csv")
  val win = Window.partitionBy("id", "name").orderBy("creditdate")
  val lagCol = lag(col("salary"), 1).over(win)
  val trend = when(col("salary") - col("lagCol") > 0, "UP")
    .when(col("salary") - col("lagCol") === 0 || (col("salary") - col("lagCol")).isNull, "SAME")
    .otherwise("DOWN")
  df.withColumn("lagCol", lagCol)
    .withColumn("trend", trend)
    .show()
}
