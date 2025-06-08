package s99

// P22 (*) Create a list containing all integers within a given range.
//     Example:
//     scala> range(4, 9)
//     res0: List[Int] = List(4, 5, 6, 7, 8, 9)

object Problem22 {
  def range(start: Int, end: Int): List[Int] = {
    def loop(end: Int, result: List[Int]): List[Int] = {
      if (end < start) result
      else loop(end - 1, end :: result)
    }

    loop(end, Nil)
  }
}
