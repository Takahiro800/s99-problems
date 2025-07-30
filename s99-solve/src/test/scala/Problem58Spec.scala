package s99

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import s99.binary_trees.*
import s99.Problem56.*
import s99.Problem58.Tree.*

class Problem58Spec extends AnyFunSpec with Matchers {
  def treeToString[T](tree: Tree[T]): String = tree match {
    case End           => "."
    case Node(v, l, r) => s"T($v ${treeToString(l)} ${treeToString(r)})"
  }

  def countNodes[T](tree: Tree[T]): Int = tree match {
    case End           => 0
    case Node(_, l, r) => 1 + countNodes(l) + countNodes(r)
  }

  describe("Tree.symmetricBalancedTrees") {
    it("should generate all symmetric completely balanced trees with 5 nodes") {
      val trees = s99.Problem58.Tree.symmetricBalancedTrees(5, "x")

      println("Generated Trees:")
      trees.map(treeToString).foreach(println)

      trees.length.shouldEqual(2)

      trees.forall(_.isSymmetric).shouldBe(true)

      trees.map(countNodes).forall(_ == 5).shouldBe(true)
    }
  }
}
