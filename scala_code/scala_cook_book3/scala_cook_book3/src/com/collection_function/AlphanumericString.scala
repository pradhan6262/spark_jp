package com.collection_function

object AlphanumericString extends App {
  val op = "abbcs5278922e7865sjasa".filter(_.isDigit).map(_.getNumericValue)
    .distinct.sorted
  println(if (op.length > 1) op.takeRight(2)(0) else -1)
}
