package s99.binary_trees

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import s99.Problem55.*

class Problem55Spec extends AnyFunSpec with Matchers {

  describe("Tree.cBalanced") {

    it("should return List(End) for 0 nodes") {
      Tree.cBalanced(0, "x") shouldEqual List(End)
    }

    it("should return a single node for 1 node") {
      Tree.cBalanced(1, "x") shouldEqual List(Node("x"))
    }

    it("should return two trees for 2 nodes") {
      val expected = List(
        Node("x", Node("x"), End),
        Node("x", End, Node("x"))
      )
      Tree.cBalanced(2, "x") should contain theSameElementsAs expected
    }

    it("should generate 4 trees for 4 nodes") {
      val trees = Tree.cBalanced(4, "x")
      trees.size shouldEqual 4
    }

    it("should generate completely balanced trees") {
      val trees = Tree.cBalanced(4, "x")
      all(trees.map(_.isBalanced)) shouldBe true
    }
  }

  // ヘルパー関数: バランスがとれているかをチェック
  implicit class TreeOps[T](tree: Tree[T]) {
    def isBalanced: Boolean = tree match {
      case End => true
      case Node(_, l, r) =>
        math.abs(l.nodeCount - r.nodeCount) <= 1 &&
        l.isBalanced && r.isBalanced
    }

    def nodeCount: Int = tree match {
      case End           => 0
      case Node(_, l, r) => 1 + l.nodeCount + r.nodeCount
    }
  }
}
