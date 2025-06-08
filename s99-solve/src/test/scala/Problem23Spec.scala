package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem23Test extends AnyFunSuite {

  test("random should return a list of the given length") {
    val input = List('a', 'b', 'c', 'd', 'e', 'f', 'g')
    val result = Problem23.random(3, input)
    assert(result.length == 3)
  }

  test("random should return elements from the original list") {
    val input = List('a', 'b', 'c', 'd', 'e', 'f', 'g')
    val result = Problem23.random(5, input)
    assert(result.forall(input.contains))
  }

  test("random should return an empty list when selecting 0 elements") {
    val input = List('a', 'b', 'c')
    val result = Problem23.random(0, input)
    assert(result.isEmpty)
  }

  test("random should not return more elements than in the input list") {
    val input = List('a', 'b', 'c')
    val result = Problem23.random(10, input)
    assert(result.length <= input.length)
  }

  test(
    "random should return distinct elements if input has no duplicates"
  ) {
    val input = List('a', 'b', 'c', 'd')
    val result = Problem23.random(3, input)
    assert(result.distinct.length == result.length)
  }
}
