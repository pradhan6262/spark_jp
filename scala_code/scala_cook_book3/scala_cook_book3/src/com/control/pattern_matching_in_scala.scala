package com.control

object pattern_matching_in_scala extends App {
  def echoWhatYouGaveMe(x: Any): Any = x match {
    case 0 => "0"
    case true => "true"
    case "hello" => "hello"
    case Nil => "an empty list"

    /**
     * sequence pattern
     */
    case List(0, _, _) => "a three element list starting with 0"
    case List(1, _*) => "a list starting with 1 having multiple element"
    case Vector(1, _*) => "a vector starting with 1 having multiple element"

    /**
     * tuple
     */
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a and $b and $c"

    /**
     * typed pattern
     */
    case s: String => s"you gave me a string $s"
    case i: Int => s"thanks for the in $i"
    case f: Float => s"thanks for the float $f"
    case as: Array[String] => s"array of string ${as.mkString(",")}"
    case lst:List[_]=>s"thanks for the list:${lst}"
    case mp:Map[_,_]=>s"thanks ${mp.mkString(",")}"
  }
  println(echoWhatYouGaveMe(List("apple", "banana")))
  println(echoWhatYouGaveMe(Map(1->"Al", 2->"Alexander")))

}
