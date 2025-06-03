package s99

import s99.Problem09.pack

object Problem11 {
  def encodeMidified[A](list: List[A]): List[Any] = list match {
    case Nil => Nil
    case _ =>
      pack(list).map(ls =>
        if (ls.length == 1) ls.head else (ls.length, ls.head)
      )
  }
}
