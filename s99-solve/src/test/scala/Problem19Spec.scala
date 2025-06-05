package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem19Test extends AnyFunSuite {

  test("rotate should rotate list left by positive N positions") {
    val input = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    val expected = List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c')
    assert(Problem19.rotate(3, input) == expected)
  }

  test("rotate should rotate list right by negative N positions") {
    val input = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    val expected = List('j', 'k', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')
    assert(Problem19.rotate(-2, input) == expected)
  }

  test("rotate by zero should return the same list") {
    val input = List(1, 2, 3, 4)
    assert(Problem19.rotate(0, input) == input)
  }

  test("rotate with N greater than list length should wrap around") {
    val input = List(1, 2, 3, 4)
    val expected = List(3, 4, 1, 2)
    assert(Problem19.rotate(6, input) == expected)
  }

  test("rotate with N less than negative list length should wrap around") {
    val input = List(1, 2, 3, 4)
    val expected = List(3, 4, 1, 2)
    assert(Problem19.rotate(-6, input) == expected)
  }

  test("rotate on empty list should return empty list") {
    assert(Problem19.rotate(3, Nil) == Nil)
  }

  test("rotate single element list returns same list") {
    assert(Problem19.rotate(1, List("only")) == List("only"))
  }
}
