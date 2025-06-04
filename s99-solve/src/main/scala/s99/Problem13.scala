package s99

object Problem13 {
  def encodeDirect[A](list: List[A]): List[(Int, A)] = list match {
    case Nil => Nil
    case _ =>
      list.foldRight(Nil) { (char, acc) =>
        if (acc.isEmpty || acc.head._2 != char) (1, char) :: acc
        else (acc.head._1 + 1, acc.head._2) :: acc.tail
      }
  }
}
