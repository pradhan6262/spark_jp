package com.control

object pattern_matching_in_scala extends App {
  def echoWhatYouGaveMe(x: Any): String = x match {
    /**
     * constant pattern
     */
    case 0 => "zero"
    case true => "true"
    case "hello" => "hello"
    case Nil => "an empty list"

    /**
     * sequence pattern
     */
    case List(0, _, _) => "a three element list begins with 0"
    case List(1, _*) => "a list begins with 1 having any number of element"
    case Vector(1, _*) => "a vector starting with 1 once having any number of element"

    /**
     * tuples
     */
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a,$b and $c"

    /**
     * typed pattern
     */
    case s: String => s"you gave me a string $s"
    case i: Int => s"thanks for int $i"
    case f: Float => s"thanks for float $f"
    case as: Array[String] => s"array of string ${as.mkString(",")}"
    case lst: List[_] => s"thanks for the list:$lst"
    case m: Map[_, _] => m.mkString(",")
    case _ => "unknown"
  }
  println(echoWhatYouGaveMe(List("apple", "banana")))
  println(echoWhatYouGaveMe(0))
  println(echoWhatYouGaveMe(true))
  println(echoWhatYouGaveMe(Map(1->"Al", 2->"Alexander")))


}
