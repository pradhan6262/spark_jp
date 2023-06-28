package com.function

object methhod_accepts_function_as_parameter extends App {
  /*  def executeFunction(callback: () => Unit): Unit = {
      callback()
    }*/
  def executeFunction(callback: Int => Unit): Unit = {
    callback(1)
  }
  /*val sayhello = () => println("hello world!!!")
  executeFunction(sayhello)*/

  def plusOne(i: Int) = {
    println(i + 1)
  }

  executeFunction(plusOne)

  def executAndPrint(f: (Int, Int) => Int, x: Int, y: Int) = {
    val res = f(x, y)
    println(res)
  }

  val sum = (x: Int, y: Int) => x + y
  val multiple = (x: Int, y: Int) => x * y
  executAndPrint(multiple,5,2)
}
