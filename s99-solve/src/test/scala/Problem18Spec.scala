package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem18Test extends AnyFunSuite {

  test(
    "slice should extract a sublist from start (inclusive) to end (exclusive)"
  ) {
    val input = List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
    val expected = List("d", "e", "f", "g")
    assert(Problem18.slice(3, 7, input) == expected)
  }

  test("slice should return Nil when start == end") {
    val input = List(1, 2, 3, 4, 5)
    assert(Problem18.slice(2, 2, input) == Nil)
  }

  test("slice should return empty when start and end are out of range") {
    val input = List(1, 2, 3)
    assert(Problem18.slice(5, 10, input) == Nil)
  }

  test("slice should handle end greater than length") {
    val input = List("x", "y", "z")
    val expected = List("y", "z")
    assert(Problem18.slice(1, 10, input) == expected)
  }

  test("slice should handle full range") {
    val input = List("x", "y", "z")
    assert(Problem18.slice(0, 3, input) == input)
  }
}
