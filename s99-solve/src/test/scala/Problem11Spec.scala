package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem11Spec extends AnyFlatSpec with Matchers {

  "Problem11.encodeMidified" should "encode consecutive duplicates as (count, element)" in {
    val input =
      List("a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    val expected = List(
      (3, "a"),
      "b",
      (2, "c"),
      (2, "a"),
      "d",
      (4, "e")
    )
    Problem11.encodeMidified(input) shouldEqual expected
  }

  it should "return an empty list when given an empty list" in {
    Problem11.encodeMidified(Nil) shouldEqual Nil
  }

  it should "return list with single element when list has one element" in {
    Problem11.encodeMidified(List("x")) shouldEqual List("x")
  }

  it should "not group non-consecutive duplicates" in {
    val input = List("a", "b", "a")
    val expected = List("a", "b", "a")
    Problem11.encodeMidified(input) shouldEqual expected
  }

}
