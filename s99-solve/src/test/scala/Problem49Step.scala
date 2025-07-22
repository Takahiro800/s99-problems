package s99

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class Problem49Spec extends AnyFunSpec with Matchers {
  describe("gray") {
    it("should return List(\"\") for n = 0") {
      Problem49.gray(0) shouldBe List("")
    }

    it("should return correct 1-bit Gray code") {
      Problem49.gray(1) shouldBe List("0", "1")
    }

    it("should return correct 2-bit Gray code") {
      Problem49.gray(2) shouldBe List("00", "01", "11", "10")
    }

    it("should return correct 3-bit Gray code") {
      Problem49.gray(3) shouldBe List(
        "000",
        "001",
        "011",
        "010",
        "110",
        "111",
        "101",
        "100"
      )
    }
  }

  describe("grayMemoized") {
    it("should return same result as gray for n = 0 to 5") {
      for (n <- 0 to 5) {
        withClue(s"n = $n: ") {
          Problem49.grayMemoized(n) shouldBe Problem49.gray(n)
        }
      }
    }
  }
}
