package s99

import org.scalatest.funspec.AnyFunSpec

class S99IntSpec extends AnyFunSpec {

  describe("isPrime") {

    it("should return true for known prime numbers") {
      val primes = List(2, 3, 5, 7, 11, 13, 17, 19, 23)
      primes.foreach(p => assert(new S99Int(p).isPrime))
    }

    it("should return false for known non-primes") {
      val nonPrimes = List(1, 4, 6, 8, 9, 10, 12, 15, 20)
      nonPrimes.foreach(n => assert(!new S99Int(n).isPrime))
    }
  }

  describe("gcd") {

    it("should return the greatest common divisor of two numbers") {
      assert(S99Int.gcd(36, 63) == 9)
      assert(S99Int.gcd(63, 36) == 9)
      assert(S99Int.gcd(17, 13) == 1)
      assert(S99Int.gcd(100, 10) == 10)
      assert(S99Int.gcd(7, 7) == 7)
    }

    it("should return the non-zero number when the other is 0") {
      assert(S99Int.gcd(5, 0) == 5)
      assert(S99Int.gcd(0, 7) == 7)
    }

    it("should handle large numbers") {
      assert(S99Int.gcd(123456, 789012) == 12)
    }
  }
}
