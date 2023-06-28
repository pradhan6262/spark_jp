package com.string

object replace_pattern_instring extends App
{
  var regex="[a-zA-Z ]+".r
  val address=regex.replaceAllIn("123 Main Street","")
  println(address)

}
