package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem22Test extends AnyFunSuite {

  val expected = List(4, 5, 6, 7, 8, 9)

  test(
    "range should generate a list of integers from start to end inclusive (builtin)"
  ) {
    assert(Problem22.range(4, 9) == expected)
  }

  test(
    "range should generate a list of integers from start to end inclusive (recursive)"
  ) {
    assert(Problem22.range(4, 9) == expected)
  }

  test(
    "range should generate a list of integers from start to end inclusive (tail recursive)"
  ) {
    assert(Problem22.range(4, 9) == expected)
  }

  test("range should return an empty list when end < start") {
    assert(Problem22.range(9, 4) == Nil)
  }

  test("range should return a single-element list when start == end") {
    assert(Problem22.range(5, 5) == List(5))
  }
}
