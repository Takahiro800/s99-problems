package s99.binary_trees

sealed abstract class Tree[+T] {
  def countNodes: Int
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString(): String = {
    "T(" + value.toString() + " " + left.toString() + " " + right
      .toString() + ")"
  }

  def countNodes: Int = 1 + left.countNodes + right.countNodes
}

case object End extends Tree[Nothing] {
  override def toString(): String = "."

  def countNodes: Int = 0
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
