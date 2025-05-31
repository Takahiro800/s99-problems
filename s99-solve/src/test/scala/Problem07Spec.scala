package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem07Spec extends AnyFlatSpec with Matchers {

  "flatten" should "return the same list if it's already flat" in {
    val input = List(1, 2, 3)
    Problem07.flatten(input) shouldEqual List(1, 2, 3)
  }

  it should "flatten a nested list" in {
    val input = List(1, List(2, 3), 4)
    Problem07.flatten(input) shouldEqual List(1, 2, 3, 4)
  }

  it should "flatten deeply nested lists" in {
    val input = List(1, List(2, List(3, List(4))), 5)
    Problem07.flatten(input) shouldEqual List(1, 2, 3, 4, 5)
  }

  it should "handle empty nested lists" in {
    val input = List(1, List(), 2)
    Problem07.flatten(input) shouldEqual List(1, 2)
  }

  it should "return empty list when given an empty list" in {
    Problem07.flatten(Nil) shouldEqual Nil
  }

  it should "handle lists of different types" in {
    val input = List(1, List("a", List(true)))
    Problem07.flatten(input) shouldEqual List(1, "a", true)
  }
}
