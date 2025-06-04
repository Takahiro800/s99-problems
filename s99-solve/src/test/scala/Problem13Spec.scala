package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem13Test extends AnyFunSuite {

  test("encodeDirect should count consecutive duplicates in a list") {
    val input = List('a', 'a', 'b', 'c', 'c', 'c', 'a')
    val expectedOutput = List((2, 'a'), (1, 'b'), (3, 'c'), (1, 'a'))
    assert(Problem13.encodeDirect(input) == expectedOutput)
  }

  test("encodeDirect should return an empty list for an empty input list") {
    val input = Nil
    val expectedOutput = Nil
    assert(Problem13.encodeDirect(input) == expectedOutput)
  }

  test("encodeDirect should handle a list with no duplicates") {
    val input = List(1, 2, 3, 4)
    val expectedOutput = List((1, 1), (1, 2), (1, 3), (1, 4))
    assert(Problem13.encodeDirect(input) == expectedOutput)
  }

  test("encodeDirect should handle a list with one element") {
    val input = List("single")
    val expectedOutput = List((1, "single"))
    assert(Problem13.encodeDirect(input) == expectedOutput)
  }
}
