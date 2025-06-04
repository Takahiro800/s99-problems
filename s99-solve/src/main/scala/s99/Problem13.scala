package s99

object Problem13 {
  def encodeDirect[A](list: List[A]): List[(Int, A)] =
    list.foldRight(Nil) {
      case (ele, (count, char) :: tail) if ele == char =>
        (count + 1, char) :: tail
      case (ele, acc) => (1, ele) :: acc
    }
}
