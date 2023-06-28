package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object windowagg extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .master("local[*]")
    .appName(this.getClass.getName)
    .getOrCreate
  val df = spark.read.option("header", "true")
    .csv("C:\\Work\\dataset\\windowdata.csv")
  val win = Window.partitionBy("country").orderBy("weeknum")
  val runningSum = sum(col("totalquantity")).over(win)
  df.withColumn("runningSum", runningSum).show()

}
