package s99

object Problem09 {
  def pack[A](list: List[A]): List[List[A]] =
    if (list.isEmpty) List(List())
    else
      list.foldRight(List[List[A]]()) {
        case (elem, Nil) => List(List(elem))
        case (elem, (head :: tail)) if elem == head.head =>
          (elem :: head) :: tail
        case (elem, acc) => List(elem) :: acc
      }
}
