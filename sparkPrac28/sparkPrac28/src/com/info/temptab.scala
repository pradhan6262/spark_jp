package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.functions.{col, explode_outer}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{ArrayType, StringType, StructField, StructType}


object temptab extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val data = Seq(Row("James Smith", List("Java", "Scala", "C++"), List("Spark", "Java"), "OH", "CA"),
    Row("Michael Rose", List("Spark", "Java", "C++"), List("Spark", "Java"), "NY", "NJ"),
    Row("Robert Williams", List("CSharp", "VB"), List("Spark", "Java"), "UT", "NV"))

  val schema = StructType(List(
    StructField("name", StringType, true),
    StructField("languagesAtSchool", ArrayType(StringType), true),
    StructField("languageAtWork", ArrayType(StringType), true),
    StructField("currentState", StringType, true),
    StructField("previousState", StringType, true)
  ))

  var df = spark.createDataFrame(spark.sparkContext.parallelize(data), schema)
  df.show()
  if (!df.select("languageAtWork").schema.fields(0).dataType.asInstanceOf[ArrayType].elementType.isInstanceOf[StringType]) {
    df = df.withColumn("languageAtWork", explode_outer(col("languageAtWork")))
  }
  df.show()

}
