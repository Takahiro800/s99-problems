package s99

object Problem04 {
  def length[A](list: List[A]): Int = {
    def recursive(len: Int, ls: List[A]): Int = {
      ls match {
        case Nil       => len
        case _ :: tail => recursive(len + 1, tail)
      }
    }

    recursive(0, list)
  }

  def lengthByFold[A](list: List[A]): Int = {
    list.foldLeft(0) { (len, _) => len + 1 }
  }
}

// P04 (*) Find the number of elements of a list.
//     Example:
//     scala> length(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 6
// scala> val list = List(1, 1, 2, 3, 5, 8)
// val list: List[Int] = List(1, 1, 2, 3, 5, 8)
//
// scala> lengthByFold(list)
// val res0: Int = 6
//
// scala> length(list)
// val res1: Int = 6
