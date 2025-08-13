package s99

import s99.binary_trees.*

object Problem59 {
  object Tree {
    def hbalTrees[T](height: Int, value: T): List[Tree[T]] = {
      height match {
        case n if n < 1 => List(End)
        case 1          => List(Node(value, End, End))
        case _ => {
          val fullHeight = hbalTrees(height - 1, value)
          val shortHeight = hbalTrees(height - 2, value)

          val sameHeights = for {
            l <- fullHeight
            r <- fullHeight
          } yield Node(value, l, r)

          val leftShorts = for {
            l <- shortHeight
            r <- fullHeight
          } yield Node(value, l, r)

          val rightShorts = for {
            l <- fullHeight
            r <- shortHeight
          } yield Node(value, l, r)

          sameHeights ++ leftShorts ++ rightShorts
        }
      }
    }
  }
}
