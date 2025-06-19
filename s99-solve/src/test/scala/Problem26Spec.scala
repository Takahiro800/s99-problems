package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem26Test extends AnyFunSuite {

  test("combinations of 3 elements from 6 should return 20 combinations") {
    val input = List("a", "b", "c", "d", "e", "f")
    val result = Problem26.combination(3, input)
    assert(result.length == 20)
    assert(result.contains(List("a", "b", "c")))
    assert(result.head.length == 3)
    assert(result.forall(_.distinct.length == 3))
  }

  test("combinations(0, xs) should return List(Nil)") {
    val result = Problem26.combination(0, List(1, 2, 3))
    assert(result == List(Nil))
  }

  test("combinations(n, xs) when n > xs.length should return Nil") {
    val result = Problem26.combination(5, List(1, 2))
    assert(result == Nil)
  }

  test(
    "combinations(n, xs) when n == xs.length should return the original list as the only combination"
  ) {
    val input = List(7, 8, 9)
    val result = Problem26.combination(3, input)
    assert(result == List(input))
  }

  test(
    "combinations of 1 element from list should return each element as singleton list"
  ) {
    val input = List("x", "y", "z")
    val expected = List(List("x"), List("y"), List("z"))
    val result = Problem26.combination(1, input)
    assert(result.toSet == expected.toSet)
  }
}
