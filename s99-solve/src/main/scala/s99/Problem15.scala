package s99

object Problem15 {
  def duplicateN[A](n: Int, list: List[A]): List[A] = {
    list.flatMap(List.fill(n)(_))
  }
}
