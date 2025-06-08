package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem21Test extends AnyFunSuite {

  test("insertAt should insert an element at a specific position in the list") {
    val result = Problem21.insertAt('x', 1, List('a', 'b', 'c', 'd'))
    assert(result == List('a', 'x', 'b', 'c', 'd'))
  }

  test("insertAt should insert at the beginning of the list") {
    val result = Problem21.insertAt('x', 0, List('a', 'b', 'c'))
    assert(result == List('x', 'a', 'b', 'c'))
  }

  test("insertAt should insert at the end of the list") {
    val result = Problem21.insertAt('x', 3, List('a', 'b', 'c'))
    assert(result == List('a', 'b', 'c', 'x'))
  }

  test("insertAt should insert into an empty list") {
    val result = Problem21.insertAt('x', 0, Nil)
    assert(result == List('x'))
  }

  test(
    "insertAt with index out of bounds should still insert at that position (appends to end)"
  ) {
    val result = Problem21.insertAt('x', 10, List('a', 'b'))
    assert(
      result == List('a', 'b', 'x')
    ) // splitAt handles out-of-bounds gracefully
  }
}
