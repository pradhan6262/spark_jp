import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6)
    val partList = ArrayBuffer(1, 2,3)
    val (op, op1) = list.partition(x => partList.contains(x))
    println(op)
    println(op1)
  }
}