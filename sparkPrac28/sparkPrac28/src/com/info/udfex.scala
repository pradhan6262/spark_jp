package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.expr

object udfex extends App {
  def parser(age: Int): String = {
    if (age >= 18) "yes"
    else "No"
  }
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val personDf = spark
    .read
    .option("inferSchema", "true")
    .csv("C:\\Work\\dataset\\person.csv")
    .toDF("name", "age", "city")
  spark.udf.register("ageCheck", parser(_: Int): String)
  personDf.withColumn("adult", expr("ageCheck(age)"))
    .show(false)
}
