package s99

object Problem10 {
  def encode[A](list: List[A]): List[(Int, A)] = list match {
    case Nil => Nil
    case _   => Problem09.pack(list).map { e => (e.length, e.head) }
  }
}
