package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem28Test extends AnyFlatSpec with Matchers {

  val input = List(
    List("a", "b", "c"),
    List("d", "e"),
    List("f", "g", "h"),
    List("d", "e"),
    List("i", "j", "k", "l"),
    List("m", "n"),
    List("o")
  )

  "lsort" should "sort lists by length ascendingly" in {
    val result = Problem28.lsort(input)
    result.map(_.length) shouldBe List(1, 2, 2, 2, 3, 3, 4)
  }

  "lsortFreq" should "sort lists by length frequency (rarer first)" in {
    val result = Problem28.lsortFreq(input)
    val lengths = result.map(_.length)

    // frequencies: 1 -> 1, 2 -> 3, 3 -> 2, 4 -> 1
    // order by frequency: 1(once), 4(once), 3(twice), 2(3 times)
    lengths shouldBe List(4, 1, 3, 3, 2, 2, 2)
  }

  it should "return empty list when input is empty" in {
    Problem28.lsortFreq(Nil) shouldBe Nil
  }

  it should "return same list if all sublists are same length" in {
    val sameLen = List(List("x"), List("y"), List("z"))
    Problem28.lsortFreq(sameLen) shouldBe sameLen
    Problem28.lsort(sameLen) shouldBe sameLen
  }
}
