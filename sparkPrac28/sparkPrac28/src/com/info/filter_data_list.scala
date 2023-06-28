package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{array_contains, col}

object filter_data_list extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate

  import spark.implicits._

  val df = Seq(
    (1, "apple"),
    (2, "banana"),
    (3, "orange"),
    (4, "mango")
  ).toDF("id", "fruit")
  val fruits = List("mango", "orange")
  df.filter(col("fruit").isInCollection(fruits)).show()
  println("++++++++++++++++++++++++++++++++++++++++++++++")
  df.filter(x => fruits.contains(x.getAs[String]("fruit"))).show()
  println("++++++++++++++++++++++++++++++++++++++++++++++")
  df.filter(array_contains(col("fruit"),fruits)).show()

}
