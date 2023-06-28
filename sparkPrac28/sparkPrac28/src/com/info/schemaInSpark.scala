package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object schemaInSpark extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.
    builder.
    appName(this.getClass.getName).
    master("local[*]").
    getOrCreate()

  val structureData = Seq(
    Row(Row("James", "", "Smith"), "36636", "M", 3100),
    Row(Row("Michael", "Rose", ""), "40288", "M", 4300),
    Row(Row("Robert", "", "Williams"), "42114", "M", 1400),
    Row(Row("Maria", "Anne", "Jones"), "39192", "F", 5500),
    Row(Row("Jen", "Mary", "Brown"), "", "F", -1)
  )

  val schema = StructType(List(
    StructField("name", StructType(List(
      StructField("firstName", StringType, true),
      StructField("middleName", StringType, true),
      StructField("lastName", StringType, true)
    ))),
    StructField("id", StringType, true),
    StructField("gender", StringType, true),
    StructField("salary", IntegerType, true)
  ))

  val df = spark.createDataFrame(
    spark.sparkContext.parallelize(structureData), schema)
  val colName = "name"
  val structCol = df.select(s"$colName.*").schema.fields.map(x => x.name)
  val structureColList = structCol.map(x => col(colName + "." + x).as(colName + "_" + x))
  var colList = (df.schema.fieldNames ++ structureColList).map(x => x.toString)
  df.selectExpr(colList: _*).drop(colName).show()




  //  var structList: List[String] = List()
  //  for (field <- fields if field.dataType.typeName == "struct") {
  //    structList = df.select(s"${field.name}.*").schema.fields.toList.map(x=>x.name)
  //  }
  //  println(structList)
}
