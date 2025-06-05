package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem17Test extends AnyFunSuite {

  test("split should split a list at the given index") {
    val input = List("a", "b", "c", "d", "e", "f")
    val expected = (List("a", "b", "c"), List("d", "e", "f"))
    assert(Problem17.split(3, input) == expected)
  }

  test("split should return (Nil, list) when index is 0") {
    val input = List(1, 2, 3)
    val expected = (Nil, List(1, 2, 3))
    assert(Problem17.split(0, input) == expected)
  }

  test(
    "split should return (list, Nil) when index is greater than list length"
  ) {
    val input = List(1, 2, 3)
    val expected = (List(1, 2, 3), Nil)
    assert(Problem17.split(5, input) == expected)
  }

  test("split should return (Nil, Nil) for empty list") {
    val input = List.empty[Int]
    val expected = (Nil, Nil)
    assert(Problem17.split(3, input) == expected)
  }
}
