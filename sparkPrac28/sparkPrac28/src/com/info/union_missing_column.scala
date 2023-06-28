package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


object union_missing_column extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate

  import spark.implicits._

  val df1 = spark.sparkContext.parallelize(List((50, 2), (34, 4)))
    .toDF("age", "children")
  val df2 = spark.sparkContext.parallelize(List((26, true, 60000.00),
    (32, false, 35000.00))).toDF("age", "education", "children")
  val col1 = df1.columns.toSet
  val col2 = df2.columns.toSet
  val colList = col1 ++ col2
  val op = df1.select(parser(col1, colList): _*).union(df2.select(parser(col2, colList): _*))
  println("+++++++++++++++++++++++++++++++++++++++++++++++")
  op.show()

  def parser(col1: Set[String], allCols: Set[String]) = {
    allCols.toList.map(x => x match {
      case x if col1.contains(x) => col(x)
      case _ => lit(null).as(x)
    })
  }
}
