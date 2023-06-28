package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object biglogdemo extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val mylist = List(("DEBUG", "2015-2-6 16:24:07"),
    ("WARN", "2016-7-26 18:54:43"),
    ("INFO", "2012-10-18 14:35:19"),
    ("DEBUG", "2012-4-26 14:26:50"),
    ("DEBUG", "2013-9-28 20:27:13"),
    ("INFO", "2017-8-20 13:17:27"),
    ("INFO", "2015-4-13 09:28:17"))
  val df = spark.createDataFrame(mylist).toDF("loglevel", "datatime")
  df.createOrReplaceTempView("logtab")
  spark.sql("select loglevel,date_format(datatime,'MM') as month from logtab")
    .show()
}
