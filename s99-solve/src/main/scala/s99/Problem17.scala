package s99

object Problem17 {
  def split[A](n: Int, list: List[A]): (List[A], List[A]) = {
    def loop(num: Int, curL: List[A], pre: List[A]): (List[A], List[A]) = {
      (num, curL) match {
        case (_, Nil)       => (pre.reverse, Nil)
        case (0, list)      => (pre.reverse, list)
        case (n, h :: tail) => loop(n - 1, tail, h :: pre)
      }
    }

    loop(n, list, Nil)
  }
}
