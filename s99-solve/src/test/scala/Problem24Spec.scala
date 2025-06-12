package s99

import org.scalatest.funsuite.AnyFunSuite

class Problem24Test extends AnyFunSuite {

  test("lotto should return the correct number of random elements") {
    val result = Problem24.lotto(6, 49)
    assert(result.length == 6)
  }

  test("lotto should only contain numbers within the specified range") {
    val max = 49
    val result = Problem24.lotto(6, max)
    assert(result.forall(n => n >= 1 && n <= max))
  }

  test("lotto should not contain duplicates") {
    val result = Problem24.lotto(10, 49)
    assert(result.distinct.length == result.length)
  }

  test("lotto with count 0 should return empty list") {
    assert(Problem24.lotto(0, 49) == Nil)
  }

  test("lotto with count greater than range should throw an exception") {
    assertThrows[IllegalArgumentException] {
      Problem24.lotto(50, 10)
    }
  }
}
