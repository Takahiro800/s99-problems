package s99

object Problem16 {
  def drop[A](n: Int, list: List[A]): List[A] = {
    if (n == 0) list
    else
      list.zipWithIndex.filter { case (_, i) => (i + 1) % n != 0 }.map(_._1)
  }

  def dropRecursive[A](n: Int, list: List[A]): List[A] = {
    def recursive(i: Int, curr: List[A], res: List[A]): List[A] =
      (i, curr) match {
        case (_, Nil)       => res.reverse
        case (1, _ :: tail) => recursive(n, tail, res)
        case (_, h :: tail) => recursive(i - 1, tail, h :: res)
      }

    recursive(n, list, Nil)
  }
}
