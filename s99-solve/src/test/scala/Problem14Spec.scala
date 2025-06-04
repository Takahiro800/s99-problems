package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem14Test extends AnyFlatSpec with Matchers {

  "duplicate" should "duplicate each element in the list" in {
    val input = List("a", "b", "c", "c", "d")
    val expected = List("a", "a", "b", "b", "c", "c", "c", "c", "d", "d")

    Problem14.duplicate(input) shouldEqual expected
  }

  it should "return an empty list when given an empty list" in {
    Problem14.duplicate(Nil) shouldEqual Nil
  }

  it should "handle a list with a single element" in {
    Problem14.duplicate(List("x")) shouldEqual List("x", "x")
  }

  it should "handle a list with different types" in {
    Problem14.duplicate(List(1, 2)) shouldEqual List(1, 1, 2, 2)
  }
}
