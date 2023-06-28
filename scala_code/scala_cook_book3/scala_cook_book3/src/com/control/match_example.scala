package com.control

object match_example extends App {
  var i = 10
  i match {
    case 1 => println("January")
    case 2 => println("February")
    case 3 => println("March")
    case 4 => println("April")
    case 5 => println("May")
    case 6 => println("June")
    case 7 => println("July")
    case 8 => println("Aug")
    case 9 => println("Sep")
    case 10 => println("October")
    case 11 => println("November")
    case 12 => println("December")
    case _ => println("out of the box !!!")
  }
  var monthNumToName = Map(
    1 -> "January",
    2 -> "February",
    3 -> "March",
    4 -> "April",
    5 -> "May",
    6 -> "June",
    7 -> "July",
    8 -> "Aug",
    9 -> "Sep",
    10 -> "October",
    11 -> "November",
    12 -> "December"
  )
  println(monthNumToName(12))
  i = 5
  i match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 0 | 2 | 4 | 6 | 8 => println("even")
  }
}
