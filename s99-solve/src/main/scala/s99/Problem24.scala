package s99

import s99.Problem23.random

// P24 (*) Lotto: Draw N different random numbers from the set 1..M.
//     Example:
//     scala> lotto(6, 49)
//     res0: List[Int] = List(23, 1, 17, 33, 21, 37)

object Problem24 {
  def lotto(count: Int, max: Int): List[Int] = {
    if (count > max) throw new IllegalArgumentException
    else
      Problem23.random(count, List.range(1, max + 1))
  }
}
