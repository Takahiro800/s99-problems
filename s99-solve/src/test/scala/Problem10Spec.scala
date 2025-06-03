package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem10Test extends AnyFunSuite {

  test("encode should count consecutive duplicates in a list") {
    val input = List('a', 'a', 'b', 'c', 'c', 'c', 'a')
    val expectedOutput = List((2, 'a'), (1, 'b'), (3, 'c'), (1, 'a'))
    assert(Problem10.encode(input) == expectedOutput)
  }

  test("encode should return an empty list for an empty input list") {
    val input = Nil
    val expectedOutput = Nil
    assert(Problem10.encode(input) == expectedOutput)
  }

  test("encode should handle a list with no duplicates") {
    val input = List(1, 2, 3, 4)
    val expectedOutput = List((1, 1), (1, 2), (1, 3), (1, 4))
    assert(Problem10.encode(input) == expectedOutput)
  }

  test("encode should handle a list with one element") {
    val input = List("single")
    val expectedOutput = List((1, "single"))
    assert(Problem10.encode(input) == expectedOutput)
  }
}
