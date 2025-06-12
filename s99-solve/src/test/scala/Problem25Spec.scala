package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem25Test extends AnyFunSuite {

  test("randomPermutate should return a permutation of the original list") {
    val input = List('a', 'b', 'c', 'd', 'e', 'f')
    val result = Problem25.randomPermutate(input)

    // 同じ要素を含む
    assert(result.sorted == input.sorted)

    // 長さが同じ
    assert(result.length == input.length)

    // 並びが変わっている可能性がある（ランダム性に依存）
    // これは非常に稀に失敗する可能性がある
    assert(result != input)
  }

  test("randomPermutate should return empty list for empty input") {
    assert(Problem25.randomPermutate(Nil) == Nil)
  }

  test("randomPermutate should return a list with one element unchanged") {
    val input = List('x')
    assert(Problem25.randomPermutate(input) == input)
  }
}
