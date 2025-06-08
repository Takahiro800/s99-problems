package s99

import s99.Problem20.removeAt

object Problem23 {
  def random[A](n: Int, list: List[A]): List[A] = {
    def loop(i: Int, ls: List[A], res: List[A]): List[A] = {
      if (i == 0) res
      else
        val (rest, e) = removeAt((new util.Random).nextInt(ls.length), ls)
        loop(i - 1, rest, e :: res)
    }

    loop(list.length.min(n), list, Nil)
  }
}
