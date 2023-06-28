package com.string

import scala.util.matching.Regex

object replace_pattern_instring extends App {
  var regex: Regex = "[a-zA-Z ]+".r
  var newAdress = regex.replaceAllIn("123 Main Street", "")
  println(newAdress)
  regex = "H".r
  println(regex.replaceFirstIn("Hello world","J"))

}
