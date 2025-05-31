package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem08Spec extends AnyFlatSpec with Matchers {

  val examples = List(
    (List("a", "a", "a", "b", "b", "c", "a", "a"), List("a", "b", "c", "a")),
    (List(1, 1, 2, 3, 3, 3, 4, 5, 5), List(1, 2, 3, 4, 5)),
    (List("a", "a", "b", "a"), List("a", "b", "a")),
    (Nil, Nil),
    (List(1), List(1)),
    (List(1, 1, 1, 1), List(1))
  )
  "compress" should "remove consecutive duplicates in various scenarios" in {
    examples.foreach { case (input, expected) =>
      Problem08.compress(input) shouldEqual expected
    }
  }

  "compressFunctional" should "also remove consecutive duplicates in various scenarios" in {
    examples.foreach { case (input, expected) =>
      Problem08.compressFunctional(input) shouldEqual expected
    }
  }
}
