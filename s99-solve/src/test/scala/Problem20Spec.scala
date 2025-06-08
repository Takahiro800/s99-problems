package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem20Test extends AnyFunSuite {

  test(
    "removeAt should remove the correct element and return the rest of the list (middle element)"
  ) {
    val input = List('a', 'b', 'c', 'd')
    val expected = (List('a', 'c', 'd'), 'b')
    assert(Problem20.removeAt(1, input) == expected)
    assert(Problem20.removeAt(1, input) == expected)
  }

  test("removeAt should remove the first element") {
    val input = List(1, 2, 3)
    val expected = (List(2, 3), 1)
    assert(Problem20.removeAt(0, input) == expected)
    assert(Problem20.removeAt(0, input) == expected)
  }

  test("removeAt should remove the last element") {
    val input = List("x", "y", "z")
    val expected = (List("x", "y"), "z")
    assert(Problem20.removeAt(2, input) == expected)
    assert(Problem20.removeAt(2, input) == expected)
  }

  test("removeAt should throw if index is negative") {
    val input = List("a", "b", "c")
    assertThrows[NoSuchElementException] {
      Problem20.removeAt(-1, input)
    }
    assertThrows[NoSuchElementException] {
      Problem20.removeAt(-1, input)
    }
  }

  test("removeAt should throw if index is out of bounds") {
    val input = List(10, 20)
    assertThrows[NoSuchElementException] {
      Problem20.removeAt(2, input)
    }
    assertThrows[NoSuchElementException] {
      Problem20.removeAt(2, input)
    }
  }

  test("removeAt should throw on empty list") {
    val input = List.empty[Int]
    assertThrows[NoSuchElementException] {
      Problem20.removeAt(0, input)
    }
    assertThrows[NoSuchElementException] {
      Problem20.removeAt(0, input)
    }
  }
}
