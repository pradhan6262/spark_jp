package com.string

import scala.util.matching.Regex

object pattern_string extends App {
  var numPattern = "[0-9]+".r
  var address = "123 Main2 Street Suite 101"
  var op = numPattern.findAllIn(address)
  op.foreach(println)

  /**
   * using regex method
   */
  numPattern = new Regex("[0-9]+")
  numPattern.findAllIn(address).foreach(println)
  /*address="dwaraka road"*/
  /**
   * get or else method
   */
  val res=numPattern.findFirstIn(address).getOrElse("124")
  println(res)
}
