package com.collection_function

object filtering_method extends App {
  val num_data = List(2, 4, 2, 6, 7, 2, 3, 3, 1)
  println(num_data)

  /**
   * distinct data
   */
  val distinct_data = num_data.distinct
  println(distinct_data)

  /**
   * dropping data
   */
  val dropping_data = num_data.drop(1)
  println(dropping_data)

  /**
   * dropping right side data
   */
  val dropping_right = num_data.dropRight(2)
  println(dropping_right)

  /**
   * dropping while
   */
  val drop_while = num_data.dropWhile(_ % 2 == 0)
  println(drop_while)

  /**
   * filter data
   */
  val filter_data = num_data.filter(_ != 2)
  println(filter_data)

  /**
   * filter not data
   */
  val filter_not_data = num_data.filterNot(_ == 2)
  println(filter_not_data)

  /**
   * find
   */
  val find_data = num_data.find(_ > 4)
  println(find_data)

  /**
   * head_data
   */
  val head_data = num_data.head
  println(head_data)

  /**
   * headOption
   */
  val head_option = num_data.headOption
  println(head_option)

  /**
   * slice data
   */
  val slice_data = num_data.slice(0, 2)
  println(slice_data)

  /**
   * tail data
   */
  val tail_data = num_data.tail
  println(tail_data)

  /**
   * take function
   */
  val take_data = num_data.take(4)
  println(take_data)

  /**
   * take_right
   */
  val take_right = num_data.takeRight(3)
  println(take_right)
  /**
   * takeWhile
   */
  val take_while_data = num_data.takeWhile(_ < 7)
  println(take_while_data)

  /**
   * withFilter
   */
  val with_filter = num_data.filter(_ > 5)
  println(with_filter)



}
