package com.collection_function

object grouping_example extends App {
  
  /**
   * group by function
   */
  val group_by = tech.groupBy(_.startsWith("s"))
  println(group_by)

  /**
   * grouped
   */
  val grouped_op = tech.grouped(2)
  println(grouped_op.toList)

  /**
   * partition
   */
  val num_list = 1 to 10
  val partition_op = num_list.partition(_ >= 5)
  println(partition_op)

  /**
   * grouped
   */
  val grouped_data = num_list.grouped(4).toList
  val max_op = grouped_data.map(x => x.max)
  println(max_op)

  /**
   * sliding
   */
  val slide_data = num_list.sliding(4).toList
  println(slide_data)

  /**
   * sliding_win_data
   */
  val slide_win_data = num_list.sliding(2, 1).toList
  println(slide_win_data)

  /**
   * span function
   */
  val span_data = num_list.span(_ <= 5)
  println(span_data)
  val my_list = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
  val span_op = my_list.span(_ == my_list.head)
  println(span_op)
}
