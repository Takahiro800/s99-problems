package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem27Test extends AnyFlatSpec with Matchers {

  "group3" should "partition 9 elements into groups of size 2, 3, and 4" in {
    val input = List(
      "Aldo",
      "Beat",
      "Carla",
      "David",
      "Evi",
      "Flip",
      "Gary",
      "Hugo",
      "Ida"
    )
    val result = Problem27.group3(input)

    result should not be empty
    all(result.map(_.map(_.size).sorted)) shouldBe List(2, 3, 4)
    all(result.map(_.flatten.sorted)) shouldBe input.sorted
  }

  "group" should "partition elements according to given sizes" in {
    val input = List(
      "Aldo",
      "Beat",
      "Carla",
      "David",
      "Evi",
      "Flip",
      "Gary",
      "Hugo",
      "Ida"
    )
    val sizes = List(2, 2, 5)
    val result = Problem27.group(sizes, input)

    result should not be empty
    all(result.map(_.map(_.size).sorted)) shouldBe sizes.sorted
    all(result.map(_.flatten.sorted)) shouldBe input.sorted
  }

  it should "throw an exception if sizes do not sum to input list length" in {
    val input = List(1, 2, 3)
    val sizes = List(2, 1, 1) // 合計は 4 > 3 → 例外が発生するはず
    an[IllegalArgumentException] should be thrownBy {
      Problem27.group(sizes, input)
    }
  }

  it should "return empty if sizes don't sum to list length (too small)" in {
    val input = List(1, 2, 3, 4)
    val sizes = List(2, 1)
    an[IllegalArgumentException] should be thrownBy {
      Problem27.group(sizes, input)
    }
  }

  it should "return empty if sizes don't sum to list length (too large)" in {
    val input = List(1, 2, 3)
    val sizes = List(2, 2)
    an[IllegalArgumentException] should be thrownBy {
      Problem27.group(sizes, input)
    }
  }

  it should "return List(Nil) when sizes is empty" in {
    val input = List(1, 2, 3)
    an[IllegalArgumentException] should be thrownBy {
      Problem27.group(Nil, input)
    }
  }
}
