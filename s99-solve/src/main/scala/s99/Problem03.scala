package s99

object Problem03 {

  def nth[A](n: Int, list: List[A]): A = {
    (n, list) match {
      case (0, h :: _)    => h
      case (n, _ :: tail) => nth(n - 1, tail)
      case (_, Nil)       => throw new NoSuchElementException
    }
  }

// scala> nth(2, List(2,4,6,8,10))
// val res0: Int = 6

}
