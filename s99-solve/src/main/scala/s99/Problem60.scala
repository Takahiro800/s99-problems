package s99

import s99.binary_trees.*
import s99.Problem59.Tree.hbalTrees

object Problem60 {
  object Tree {
    def countNodes[T](tree: Tree[T]): Int = {
      tree match {
        case End                  => 0
        case Node(_, left, right) => 1 + countNodes(left) + countNodes(right)
      }
    }

    def minHbalHeight(nodes: Int): Int =
      if (nodes == 0) 0
      else minHbalHeight(nodes / 2) + 1

    def maxHbalHeight(nodes: Int): Int =
      LazyList.from(1).takeWhile(minHbalNodes(_) <= nodes).last

    def minHbalNodes(height: Int): Int = {
      height match {
        case n if n < 1 => 0
        case 1          => 1
        case n          => minHbalNodes(n - 1) + minHbalNodes(n - 2) + 1
      }
    }

    def maxHbalNodes(height: Int): Int = {
      2 * height - 1
    }

    def hbalTreesWithNodes[T](nodes: Int, value: T): List[Tree[T]] = {
      val minH = minHbalHeight(nodes)
      val maxH = maxHbalHeight(nodes)
      println(s"minH = $minH, maxH = $maxH") // デバッグ用
      if (minH > maxH) return Nil
      (minH to maxH)
        .flatMap(h => hbalTrees(h, value))
        .filter(t => countNodes(t) == nodes)
        .toList
    }
  }
}
