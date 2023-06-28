object Main {
  def main(args: Array[String]): Unit = {
    val line = "February,11000.00,9500.00,1500.00"
    val Array(month, revenue, expenses, profit) = line.split(",")
    println(s"$month#$revenue#$expenses#$profit")
  }
}