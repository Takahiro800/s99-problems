package s99

// P18 (**) Extract a slice from a list.
//     Given two indices, I and K, the slice is the list containing the elements
//     from and including the Ith element up to but not including the Kth
//     element of the original list.  Start counting the elements with 0.
//
//     Example:
//     scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g)

object Problem18 {
  def slice[A](str: Int, end: Int, ls: List[A]): List[A] = {
    ls.zipWithIndex.foldRight(Nil) { case ((ele, i), res) =>
      if (str <= i && i < end) ele :: res
      else res
    }
  }
}
