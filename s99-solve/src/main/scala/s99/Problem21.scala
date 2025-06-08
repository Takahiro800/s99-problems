package s99

// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

object Problem21 {
  def insertAt[A](target: A, n: Int, ls: List[A]): List[A] = {
    val (pre, post) = ls.splitAt(n)
    pre ::: target :: post
  }
}
