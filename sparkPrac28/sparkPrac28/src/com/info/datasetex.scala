package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object datasetex extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val df = spark.read.option("header", "true")
    .csv("C:\\Work\\dataset\\orders.txt")
  import spark.implicits._
  val op=df.map(x=>(x.getAs[String]("order_customer_id"),
    x.getAs[String]("order_status"))).toDF("order_customer_id","order_status")
  op.show()
}
