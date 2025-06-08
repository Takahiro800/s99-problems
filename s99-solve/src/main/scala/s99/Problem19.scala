package s99

// P19 (**) Rotate a list N places to the left.
//     Examples:
//     scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
//
//     scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

object Problem19 {
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    if (ls.isEmpty) Nil
    else
      val len = ls.length
      val boundedN = ((n % len) + len) % len
      List(ls.drop(boundedN), ls.take(boundedN)).flatten
  }
}
