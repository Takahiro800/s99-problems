package s99

object Problem05 {
  def reverse[A](list: List[A]): List[A] = {
    def go[A](ls: List[A], rev: List[A]): List[A] = {
      ls match {
        case Nil       => rev
        case h :: tail => go(tail, h :: rev)
      }
    }

    go(list, Nil)
  }

  def reverseByFold[A](list: List[A]): List[A] = {
    list.foldLeft(Nil)((r, h) => h :: r)
  }
  // P05 (*) Reverse a list.
  //     scala> reverse(List(1, 1, 2, 3, 5, 8))
  //     res0: List[Int] = List(8, 5, 3, 2, 1, 1)
}
