package s99

object Problem10 {
  def encode[A](list: List[A]): List[(Int, A)] = {
    Problem09.pack(list).map { e => (e.length, e.head) }
  }
}
