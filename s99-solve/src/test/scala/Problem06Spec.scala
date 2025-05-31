package s99

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem06Spec extends AnyFlatSpec with Matchers {

  "isPalindrome" should "return true for a palindrome list of integers" in {
    Problem06.isPalindrome(List(1, 2, 3, 2, 1)) shouldBe true
  }

  it should "return false for a non-palindrome list of integers" in {
    Problem06.isPalindrome(List(1, 2, 3)) shouldBe false
  }

  it should "return true for an empty list" in {
    Problem06.isPalindrome(Nil) shouldBe true
  }

  it should "return true for a single-element list" in {
    Problem06.isPalindrome(List('a')) shouldBe true
  }

  it should "return true for a palindrome list of strings" in {
    Problem06.isPalindrome(List("a", "b", "c", "b", "a")) shouldBe true
  }
}
