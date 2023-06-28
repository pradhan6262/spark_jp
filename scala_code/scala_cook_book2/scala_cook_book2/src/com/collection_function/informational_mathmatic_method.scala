package com.collection_function

object informational_mathmatic_method extends App {
  val a = "foo bar baz"
  val evens = List(2, 4, 6)

  /**
   * count function
   */
  println(a.count(_ == 'a'))
  println(a.endsWith("baz"))
  println(evens.exists(_ > 2))

  /**
   * fold
   */
  val list = List(1, 2, 3, 4, 5)
  val sum = list.fold(0)((x, y) => x + y)
  println(sum)

  /**
   * fold left
   */
  val fold_left = list.foldLeft(0)((x, y) => x + y)
  println(fold_left)

  /**
   * fold right
   */
  val fold_right = list.foldRight(0)((x, y) => x + y)
  println(fold_right)

  /**
   * for all
   */
  var for_all_data = evens.forall(_ >= 2)
  println(for_all_data)

}
