package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object datasetex extends App
{
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark=SparkSession.
    builder.
    appName(this.getClass.getName).
    master("local[*]").getOrCreate()


}
