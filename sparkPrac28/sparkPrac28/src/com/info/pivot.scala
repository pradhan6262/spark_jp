package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object pivot extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder.appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val df=spark.read.option("header","true")
    .csv("C:\\Work\\dataset\\biglog.txt")
  df.createOrReplaceTempView("logtab")
  val months=List("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
  spark.sql("select level,date_format(datetime,'MMMM') as month from logtab")
    .groupBy("level").pivot("month",months)
    .count().show()
}
