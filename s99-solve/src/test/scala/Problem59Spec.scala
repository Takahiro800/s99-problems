package s99

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import Problem59.*
import s99.binary_trees.*

class Problem59Spec extends AnyFunSpec with Matchers {

  describe("Tree.hbalTrees") {

    it("should return only End when height = 0") {
      Tree.hbalTrees(0, "x") shouldBe List(End)
    }

    it("should return a single Node(value) when height = 1") {
      Tree.hbalTrees(1, "x") shouldBe List(Node("x"))
    }

    it("should generate correct number of trees for small heights") {
      // P59 has known counts for small heights (for example height=3)
      Tree.hbalTrees(3, "x").size shouldBe 15
    }
  }
}
