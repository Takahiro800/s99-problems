package s99

// P26 (**) Generate the combinations of K distinct objects chosen from the N
//          elements of a list.
//     In how many ways can a committee of 3 be chosen from a group of 12
//     people?  We all know that there are C(12,3) = 220 possibilities (C(N,K)
//     denotes the well-known binomial coefficient).  For pure mathematicians,
//     this result may be great.  But we want to really generate all the possibilities.
//
//     Example:
//     scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
//     res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

object Problem26 {
  def flatMApSublists[A, B](ls: List[A])(f: List[A] => List[B]): List[B] = {
    ls match {
      case Nil                   => Nil
      case sublist @ (_ :: tail) => f(sublist) ::: flatMApSublists(tail)(f)
    }
  }

  def combination[A](n: Int, ls: List[A]): List[List[A]] = {
    if (n == 0) List(Nil)
    else
      flatMApSublists(ls) { sl =>
        combination(n - 1, sl.tail).map(sl.head :: _)
      }
  }
}
