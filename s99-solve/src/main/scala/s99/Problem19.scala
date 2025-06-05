package s99

object Problem19 {
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    if (ls.isEmpty) Nil
    else
      val len = ls.length
      val boundedN = ((n % len) + len) % len
      List(ls.drop(boundedN), ls.take(boundedN)).flatten
  }
}
