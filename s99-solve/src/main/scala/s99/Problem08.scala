package s99

object Problem08 {
  def compress[A](list: List[A]): List[A] = {
    def recursive[A](curr: List[A], res: List[A]): List[A] = {
      curr match {
        case h :: tail => recursive(tail.dropWhile(_ == h), h :: res)
        case Nil       => res.reverse
      }
    }

    recursive(list, Nil)
  }

  def compressFunctional[A](list: List[A]): List[A] = {
    list.foldRight(Nil) { (ele, res) =>
      if (res.isEmpty || res.head != ele) ele :: res
      else res
    }
  }
}
