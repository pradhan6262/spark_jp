package com.control

import scala.util.control.Breaks.{break, breakable}

object break_in_loop extends App {
  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4) break
    }
  }
  val searchMe = "peter piper picked a peck of pickled peppers"
  var nump = 0
  for (i <- 0 until searchMe.length) {
    breakable {
      if (searchMe.charAt(i) != 'p')
        break
      else
        nump += 1
    }
  }
  println(s"Found  + $nump +  p's in the string.")
}
