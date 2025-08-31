package s99

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import s99.binary_trees.*
import Problem60.*

class Problem60Spec extends AnyFunSpec with Matchers {

  describe("Tree.minHbalNoteds") {
    it("should return 0 for height 0") {
      Tree.minHbalNodes(0) shouldBe 0
    }
    it("should return 1 for height 1") {
      Tree.minHbalNodes(1) shouldBe 1
    }
    it("should return 4 for height 3") {
      Tree.minHbalNodes(3) shouldBe 4
    }
  }

  describe("Tree.maxHbalHeight") {
    it("should return 3 for 4 nodes") {
      Tree.maxHbalHeight(4) shouldBe 3
    }
    it("should increase with nodes") {
      Tree.maxHbalHeight(15) should be > 3
    }
  }

  describe("Tree.hbalTreesWithNodes") {
    it("should generate only trees with exactly n nodes") {
      val trees = Tree.hbalTreesWithNodes(4, "x")
      trees should not be empty
      all(trees.map(Tree.countNodes)) shouldBe 4
    }

    it("should generate the known count for N=15") {
      val trees = Tree.hbalTreesWithNodes(15, "x")
      trees.size shouldBe 1553
    }
  }
}
