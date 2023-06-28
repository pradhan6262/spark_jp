package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object unstructuredf extends App {
  case class orders(order_id: Int, order_customer_id: Int, status: String)

  val regex = """^(\S+) (\S+)\t(\S+),(\S+)""".r

  def parser(input: String): orders = input match {
    case regex(order_id, orders_date, order_customer_id, status) =>
      orders(order_id.toInt, order_customer_id.toInt, status)
  }

  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession
    .builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate
  val data = spark.sparkContext.textFile("C:\\Work\\dataset\\data.txt")

  import spark.implicits._

  val df = data.map(parser).toDF()
  df.show()
}
