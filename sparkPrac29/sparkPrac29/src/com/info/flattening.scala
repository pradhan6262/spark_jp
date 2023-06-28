package com.info

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{ArrayType, StringType, StructType}

import scala.collection.mutable
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
      |                      "state": "New Delhi",
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

  import spark.implicits._

  val ds = spark.read.json(Seq(data).toDS())
  val fields = ds.select("datasets").schema.fields
  val field = fields(0)
  println(field.name + "," + field.dataType.asInstanceOf[ArrayType].elementType.isInstanceOf[StructType])
  //  val op = flatten(ds)
  //  op.show()
  ds.printSchema()


  def flatten(ds: DataFrame): DataFrame = {
    var df = ds
    var complexFields = HashMap[String, String]()
    df.schema.fields.filter(x => x.dataType.typeName == "array" || x.dataType.typeName == "struct")
      .map(x => complexFields.put(x.name, x.dataType.typeName))
    while (complexFields.size > 0) {
      val colName = complexFields.keySet.toList(0)
      if (complexFields(colName) == "struct") {
        val structCol = df.select(s"$colName.*").schema.fieldNames
        val expanded = structCol.map(x => col(colName + "." + x).alias(colName + "_" + x))
        val colList = (df.schema.fieldNames ++ expanded).map(_.toString)
        df = df.selectExpr(colList: _*).drop(colName)
        complexFields = HashMap[String, String]()
      }
      else if (complexFields(colName) == "array") {
        df = df.withColumn(colName, explode_outer(col(colName)))
      }
      df.schema.fields.filter(x => x.dataType.typeName == "array" || x.dataType.typeName == "struct")
        .map(x => complexFields.put(x.name, x.dataType.typeName))
    }
    df
  }
}
