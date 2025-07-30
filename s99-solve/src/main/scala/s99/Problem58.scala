package s99

import s99.binary_trees.*
import s99.Problem55.Tree
import s99.Problem56.*

object Problem58 {
  object Tree {
    def symmetricBalancedTrees[T](nodes: Int, value: T): List[Tree[T]] = {
      s99.Problem55.Tree.cBalanced(nodes, value).filter(_.isSymmetric)
    }
  }
}
