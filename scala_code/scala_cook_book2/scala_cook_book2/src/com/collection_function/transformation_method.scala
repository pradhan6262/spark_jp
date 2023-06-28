package com.collection_function

object transformation_method extends App {
  val data_list = List("hello", "hello again", 40, "bye", 60, 80, 100, "i am string as well !!")
  val collect_data = data_list.collect(
    {
      case x: String => x
    })
  println(collect_data)

  /**
   * diff function
   */
  val data1 = List(1, 2, 3, 4, 5)
  val data2 = List(3, 4, 5, 6, 7, 8)
  val diff1 = data1 diff data2
  val diff2 = data2 diff data1
  println(diff1 ::: diff2)

  /**
   * flatten
   */
  val list1 = List(1, 2)
  val list2 = List(3, 4)
  val lol = List(list1, list2)
  println(lol)
  println(lol.flatten)

  /**
   * distinct
   */
  val m1 = List(1, 1, 3, 3, 3, 5, 4, 5, 2)
  println(m1.distinct)

  /**
   * reverse
   */
  val l1 = List(1, 2, 3, 4, 5, 6)
  val reverse_data = l1.reverse
  println(reverse_data)

  /**
   * sorting
   */
  val mylist = List("banana", "pear", "apple", "orange").sortWith(_.length < _.length)
  println(mylist)

}
