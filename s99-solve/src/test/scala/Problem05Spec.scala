package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem05Spec extends AnyFlatSpec with Matchers {

  "reverse" should "reverse a non-empty list correctly" in {
    Problem05.reverse(List(1, 1, 2, 3, 5, 8)) shouldBe List(8, 5, 3, 2, 1, 1)
  }

  it should "return an empty list when given an empty list" in {
    Problem05.reverse(Nil) shouldBe Nil
  }

  it should "work for a single-element list" in {
    Problem05.reverse(List(42)) shouldBe List(42)
  }

  "reverseByFold" should "reverse a non-empty list correctly" in {
    Problem05.reverseByFold(List(1, 1, 2, 3, 5, 8)) shouldBe List(8, 5, 3, 2, 1,
      1)
  }

  it should "return an empty list when given an empty list" in {
    Problem05.reverseByFold(Nil) shouldBe Nil
  }

  it should "work for a single-element list" in {
    Problem05.reverseByFold(List(42)) shouldBe List(42)
  }

  "reverse and reverseByFold" should "produce the same result" in {
    val input = List.range(1, 100)
    Problem05.reverse(input) shouldBe Problem05.reverseByFold(input)
  }
}
