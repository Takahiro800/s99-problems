package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import Problem16.{drop, dropRecursive}

class Problem16Test extends AnyFlatSpec with Matchers {

  "drop" should "drop every nth element" in {
    val input = List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
    val expected = List("a", "b", "d", "e", "g", "h", "j", "k")
    drop(3, input) shouldEqual expected
    dropRecursive(3, input) shouldEqual expected
  }

  it should "return the same list when n is greater than the list size" in {
    val input = List(1, 2, 3)
    drop(5, input) shouldEqual input
    dropRecursive(5, input) shouldEqual input
  }

  it should "return an empty list when the input is empty" in {
    drop(3, Nil) shouldEqual Nil
    dropRecursive(3, Nil) shouldEqual Nil
  }

  it should "drop every element when n is 1" in {
    drop(1, List("x", "y", "z")) shouldEqual Nil
    dropRecursive(1, List("x", "y", "z")) shouldEqual Nil
  }

  it should "not drop anything when n is 0" in {
    val input = List("a", "b", "c")
    drop(0, input) shouldEqual input
    dropRecursive(0, input) shouldEqual input
  }
}
