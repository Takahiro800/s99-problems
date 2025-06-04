package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem15Test extends AnyFlatSpec with Matchers {

  "duplicateN" should "duplicate each element n times" in {
    val input = List("a", "b", "c", "c", "d")
    val expected = List(
      "a",
      "a",
      "a",
      "b",
      "b",
      "b",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "d",
      "d",
      "d"
    )

    Problem15.duplicateN(3, input) shouldEqual expected
  }

  it should "return an empty list when input is empty" in {
    Problem15.duplicateN(3, Nil) shouldEqual Nil
  }

  it should "return an empty list when n is 0" in {
    Problem15.duplicateN(0, List("x", "y")) shouldEqual Nil
  }

  it should "handle a list with one element" in {
    Problem15.duplicateN(2, List("z")) shouldEqual List("z", "z")
  }

  it should "handle integers and other types" in {
    Problem15.duplicateN(2, List(1, 2)) shouldEqual List(1, 1, 2, 2)
  }
}
