package s99

object Problem02 {
  def penultimateRecursive[A](list: List[A]): A = {
    list match {
      case h :: _ :: Nil => h
      case _ :: tail     => penultimateRecursive(tail)
      case _             => throw new NoSuchElementException
    }
  }
}

// scala> Problem02.penultimateRecursive(List(1, 1, 2, 3, 5, 8))
// val res0: Int = 5
