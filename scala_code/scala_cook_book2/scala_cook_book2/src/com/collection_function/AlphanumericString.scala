package com.collection_function

object AlphanumericString extends App {
  val op = "abbcs5278922e7865sjasa".replaceAll("[a-zA-Z]", "")
    .map(_.getNumericValue).distinct.sorted
  println(if (op.length > 1) op(op.length - 2) else -1)
}
