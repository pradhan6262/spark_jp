package com.string

object multiline_string extends App {
  /**
   * creating multiline string
   */
  var foo =
    """This
      is a multiline
      string"""
  println(foo)

  /**
   * creating multiline string with strip margin
   */
  var speech =
    """four score
      |and seven
      |years ago""".stripMargin
  println(speech)

  /**
   * multiline string with strip margin #
   */
  speech =
    """four score
      #and seven
      #years ago""".stripMargin('#')
  println(speech)
  val sv=
    """fb score
      |and seven
      |years ago""".stripMargin.replaceAll("\n"," ")
  println(sv)

}
