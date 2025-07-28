package s99

import s99.binary_trees._

object Problem55 {
  object Tree {
    def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = {
      if (nodes == 0) List(End)
      else {
        val half = (nodes - 1) / 2
        val rem = (nodes - 1) - half
        val pairs =
          if (half == rem) List((half, rem))
          else List((half, rem), (rem, half))

        for {
          (lSize, rSize) <- pairs
          l <- cBalanced(lSize, value)
          r <- cBalanced(rSize, value)
        } yield Node(value, l, r)
      }
    }
  }
}
