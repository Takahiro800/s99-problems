package s99

import s99.Problem26.combination

object Problem27 {
  def group3[A](ls: List[A]): List[List[List[A]]] = {
    for {
      a <- combination(2, ls)
      noA = ls.diff(a) // 差分を計算
      b <- combination(3, noA)
    } yield List(a, b, noA.diff(b))
  }

  def group[A](counts: List[Int], ls: List[A]): List[List[List[A]]] = {
    if (counts.sum != ls.length)
      throw new IllegalArgumentException(
        "The sum of group sizes must equal the number of elements."
      )

    counts match {
      case Nil => List(Nil)
      case i :: tail =>
        combination(i, ls).flatMap(comb =>
          group(tail, ls.diff(comb)).map(comb :: _)
        )
    }
  }
}
