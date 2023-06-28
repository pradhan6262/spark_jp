package com.string

object testing_string_equality extends App {
  var s1 = "Hello"
  var s2 = "Hello"
  var s3 = "H" + "ello"
  println(s1 == s3)

  /**
   * comparing string with different cases
   */
  s1 = "Hello"
  s2 = "hello"
  println(s1.toUpperCase == s2.toUpperCase)

  /**
   * comparing with null value
   */

  /** s1 = null
   * s2 = null
   * println(s1.toUpperCase == s2.toUpperCase)
   */
  s1 = "marisa"
  s2 = "Marisa"
  println(s1.equalsIgnoreCase(s2))


}
