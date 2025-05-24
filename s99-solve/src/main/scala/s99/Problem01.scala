package s99

object Problem01 {

  /** Find the last element of a list. Example: scala> last(List(1, 1, 2, 3, 5,
    * 8)) res0: Int = 8
    */
  def lastRecursive[A](list: List[A]): A = {
    list match {
      case h :: Nil  => h
      case _ :: tail => lastRecursive(tail)
      case Nil       => throw new NoSuchElementException
    }
  }

  // scala> Problem01.lastRecursive(List(1, 1, 2, 3, 5, 8))
  // val res0: Int = 8

}
