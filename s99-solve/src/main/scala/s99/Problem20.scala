package s99

// P20 (*) Remove the Kth element from a list.
//     Return the list and the removed element in a Tuple.  Elements are
//     numbered from 0.
//
//     Example:
//     scala> removeAt(1, List('a, 'b, 'c, 'd))
//     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

object Problem20 {
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = {
    if (n < 0) throw new NoSuchElementException
    else
      (n, ls) match {
        case (_, Nil)       => throw new NoSuchElementException
        case (0, h :: tail) => (tail, h)
        case (_, h :: tail) => {
          val (t, e) = removeAt(n - 1, ls.tail)
          (ls.head :: t, e)
        }
      }
  }
}
