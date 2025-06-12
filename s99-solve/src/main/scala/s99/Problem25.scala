package s99

import s99.Problem23.random

// P25 (*) Generate a random permutation of the elements of a list.
//     Hint: Use the solution of problem P23.
//
//     Example:
//     scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
//     res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

object Problem25 {
  def randomPermutate[A](ls: List[A]): List[A] = {
    random(ls.length, ls)
  }
}
