import org.scalatest.funspec.AnyFunSpec

import s99.binary_trees.*
import s99.Problem56.*
import s99.Problem57.*

class Problem57Spec extends AnyFunSpec {
  describe("Tree#addValue") {
    it("should insert a value into an empty tree") {
      assert(End.addValue(2).toString == "T(2 . .)")
    }

    it("should insert a value to the right") {
      val tree = End.addValue(2).addValue(3)
      assert(tree.toString == "T(2 . T(3 . .))")
    }

    it("should insert a value to the left") {
      val tree = End.addValue(2).addValue(3).addValue(0)
      assert(tree.toString == "T(2 T(0 . .) T(3 . .))")
    }
  }

  describe("Tree#fromList") {
    it("should build a tree from list") {
      val tree = Tree.fromList(List(3, 2, 5, 7, 1))
      assert(tree.toString == "T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))")
    }
  }

  describe("Tree#isSymmetric") {
    it("should return true for a symmetric tree") {
      val tree = Tree.fromList(List(5, 3, 18, 1, 4, 12, 21))
      assert(tree.isSymmetric)
    }

    it("should return false for a non-symmetric tree") {
      val tree = Tree.fromList(List(3, 2, 5, 7, 4))
      assert(!tree.isSymmetric)
    }
  }
}
