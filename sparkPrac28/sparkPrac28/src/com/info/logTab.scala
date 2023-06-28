package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object logTab extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val df = spark.read.option("header", "true")
    .csv("C:\\Work\\dataset\\biglog.txt")
  df.createOrReplaceTempView("logtab")
  spark.sql("select level,date_format(datetime,'MM') as month,count(*) as cnt,first(cast(date_format(datetime,'MM') as int)) as monthNum from logtab group by level,month order by monthNum")
    .show(100)
}
