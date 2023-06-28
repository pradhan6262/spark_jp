package com.info


import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{ArrayType, StringType}

import scala.collection.mutable._

object flattening extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.
    builder.
    appName(this.getClass.getName).
    master("local[*]").
    getOrCreate()
  val data =
    """{
      |          "filename": "orderDetails",
      |          "company":"ALLSTATE",
      |          "datasets": [
      |              {
      |                  "orderId": "ord1001",
      |                  "customerId": "cust5001",
      |                  "orderDate": "2021-12-24 00.00.00.000",
      |                  "shipmentDetails": {
      |                      "street": "M.G.Road",
      |                      "city": "Delhi",
      |                      "state": ["New Delhi","BBSR"],
      |                      "postalCode": "110040",
      |                      "country": "India"
      |                  },
      |                  "orderDetails": [
      |                    {
      |                      "productId": "prd9001",
      |                      "quantity": 2,
      |                      "sequence": 1,
      |                      "totalPrice": {
      |                        "gross": 550,
      |                        "net": 500,
      |                        "tax": 50
      |                      }
      |                    },
      |                    {
      |                      "productId": "prd9002",
      |                      "quantity": 3,
      |                      "sequence": 2,
      |                      "totalPrice": {
      |                        "gross": 300,
      |                        "net": 240,
      |                        "tax": 60
      |                      }
      |                    }
      |                  ]
      |              },
      |              {
      |                  "orderId": "ord1002",
      |                  "customerId": "cust5002",
      |                  "orderDate": "2021-12-25 00.00.00.000",
      |                  "shipmentDetails": {
      |                      "street": "Malad",
      |                      "city": "Mumbai",
      |                      "state": "Maharastra",
      |                      "postalCode": "400064",
      |                      "country": "India"
      |                  },
      |                  "orderDetails": [
      |                    {
      |                      "productId": "prd9001",
      |                      "quantity": 1,
      |                      "sequence": 1,
      |                      "totalPrice": {
      |                        "gross": 275,
      |                        "net": 250,
      |                        "tax": 25
      |                      }
      |                    },
      |                    {
      |                      "productId": "prd9004",
      |                      "quantity": 4,
      |                      "sequence": 2,
      |                      "totalPrice": {
      |                        "gross": 1000,
      |                        "net": 900,
      |                        "tax": 100
      |                      }
      |                    }
      |                  ]
      |              }
      |          ]
      |      }""".stripMargin

  def flatten(ds: DataFrame): DataFrame = {
    var df: DataFrame = ds
    var complexFields = HashMap[String, String]()
    df.schema.fields.filter(x => (x.dataType.typeName == "array") || x.dataType.typeName == "struct").map(x => complexFields.put(x.name, x.dataType.typeName))
    val arrayStringCol = ListBuffer[String]("dummy")
    while (complexFields.size > 0) {
      val colName = complexFields.keySet.toList(0)
      if (complexFields(colName) == "array" && df.select(colName).schema.fields(0).dataType.asInstanceOf[ArrayType].elementType.isInstanceOf[StringType]) {
        df = df.withColumn(colName, df(colName)(0))
        complexFields = HashMap[String, String]()
        arrayStringCol.append(colName)
      }
      if (complexFields(colName) == "struct") {
        val structCol = df.select(s"$colName.*").schema.fields.map(x => x.name)
        val expanded = structCol.map(x => col(colName + "." + x).as(colName + "_" + x))
        val colList = (df.schema.fieldNames ++ expanded).map(_.toString)
        df = df.selectExpr(colList: _*).drop(colName)
        complexFields = HashMap[String, String]()
      }
      else if (complexFields(colName) == "array") {
        df = df.withColumn(colName, explode_outer(col(colName)))
        complexFields = HashMap[String, String]()
      }
      df.schema.fields.filter(x => (x.dataType.typeName == "array" || x.dataType.typeName == "struct") && !arrayStringCol.contains(x.name)).map(x => complexFields.put(x.name, x.dataType.typeName))
    }
    df
  }

  import spark.implicits._

  var ds = spark.read.option("multiLine", "true").json(Seq(data).toDS)
  val op = flatten(ds)
  op.show()
}
