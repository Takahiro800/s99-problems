package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem09Spec extends AnyFlatSpec with Matchers {

  "Problem09.pack" should "group consecutive duplicates into sublists" in {
    val input =
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    val expected = List(
      List("a", "a", "a", "a"),
      List("b"),
      List("c", "c"),
      List("a", "a"),
      List("d"),
      List("e", "e", "e", "e")
    )
    Problem09.pack(input) shouldEqual expected
  }

  it should "return an empty list when given an empty list" in {
    Problem09.pack(List()) shouldEqual List(List())
  }

  it should "handle a list with one element" in {
    Problem09.pack(List("x")) shouldEqual List(List("x"))
  }

  it should "handle a list with no consecutive duplicates" in {
    val input = List("a", "b", "c")
    val expected = List(List("a"), List("b"), List("c"))
    Problem09.pack(input) shouldEqual expected
  }

}
