package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem12Spec extends AnyFlatSpec with Matchers {

  "decode" should "expand the encoded list into its original form" in {
    val encoded =
      List((4, "a"), (1, "b"), (2, "c"), (2, "a"), (1, "d"), (4, "e"))
    val expected =
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")

    Problem12.decode(encoded) shouldEqual expected
  }

  it should "return an empty list when given an empty list" in {
    Problem12.decode(Nil) shouldEqual Nil
  }

  it should "handle single-element counts correctly" in {
    Problem12.decode(List((1, 42))) shouldEqual List(42)
  }

  it should "handle count = 0 correctly (even though it should be avoided)" in {
    Problem12.decode(List((0, "x"))) shouldEqual Nil
  }
}
