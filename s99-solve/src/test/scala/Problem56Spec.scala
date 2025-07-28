package s99.binary_trees

import s99.Problem56.*

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class Problem56Spec extends AnyFunSpec with Matchers {
  describe("Tree#isSymmetric") {

    it("should return true for an empty tree") {
      End.isSymmetric shouldBe true
    }

    it("should return true for a symmetric tree (structure only)") {
      //     x
      //    / \
      //   x   x
      val tree = Node("a", Node("b", End, End), Node("c", End, End))
      tree.isSymmetric shouldBe true
    }

    it("should return false for an asymmetric tree (structure only)") {
      //     x
      //    / \
      //   x   x
      //  /
      // x
      val tree = Node(
        "root",
        Node("left", Node("leaf", End, End), End),
        Node("right", End, End)
      )
      tree.isSymmetric shouldBe false
    }

    it("should return true for a deeper symmetric tree (structure only)") {
      //         x
      //       /   \
      //      x     x
      //     / \   / \
      //    x   x x   x
      val tree = Node(
        "r",
        Node("l", Node("ll", End, End), Node("lr", End, End)),
        Node("r", Node("rl", End, End), Node("rr", End, End))
      )
      tree.isSymmetric shouldBe true
    }

    it("should return false if only one child exists") {
      //   x
      //  /
      // x
      val tree = Node("x", Node("x", End, End), End)
      tree.isSymmetric shouldBe false
    }
  }
}
