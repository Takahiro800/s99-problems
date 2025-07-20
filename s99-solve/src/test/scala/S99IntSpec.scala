package s99

import org.scalatest.funspec.AnyFunSpec

class S99IntSpec extends AnyFunSpec {
  import s99.S99Int.RichInt

  describe("isPrime") {

    it("should return true for known prime numbers") {
      val primes = List(2, 3, 5, 7, 11, 13, 17, 19, 23)
      primes.foreach(p => assert(p.isPrime))
    }

    it("should return false for known non-primes") {
      val nonPrimes = List(1, 4, 6, 8, 9, 10, 12, 15, 20)
      nonPrimes.foreach(n => assert(!n.isPrime))
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

  describe("isCoprimeTo") {
    it("should return true for coprime numbers") {
      assert(7.isCoprimeTo(9)) // gcd(7, 9) == 1
      assert(13.isCoprimeTo(4)) // gcd(13, 4) == 1
      assert(8.isCoprimeTo(15)) // gcd(8, 15) == 1
    }

    it("should return false for non-coprime numbers") {
      assert(!6.isCoprimeTo(9)) // gcd(6, 9) == 3
      assert(!12.isCoprimeTo(15)) // gcd(12, 15) == 3
      assert(!18.isCoprimeTo(24)) // gcd(18, 24) == 6
    }

    it("should handle edge cases with zero and one") {
      assert(1.isCoprimeTo(0)) // gcd(1, 0) == 1
      assert(!0.isCoprimeTo(0)) // gcd(0, 0) is undefined, should return false
      assert(7.isCoprimeTo(1)) // gcd(7, 1) == 1
    }

  }

  describe("totient") {
    it("should return the correct totient value for known cases") {
      assert(1.totient == 1)
      assert(2.totient == 1)
      assert(3.totient == 2)
      assert(4.totient == 2)
      assert(5.totient == 4)
    }

    it("should handle larger numbers correctly") {
      assert(10.totient == 4)
      assert(12.totient == 4)
    }
  }

  describe("primeFactors") {
    it("should return the prime factors for small numbers") {
      assert(12.primeFactors == List(2, 2, 3))
      assert(15.primeFactors == List(3, 5))
      assert(28.primeFactors == List(2, 2, 7))
    }

    it("should return the prime factor for a prime number") {
      assert(13.primeFactors == List(13))
      assert(19.primeFactors == List(19))
    }

    it("should handle large numbers correctly") {
      assert(315.primeFactors == List(3, 3, 5, 7))
      assert(462.primeFactors == List(2, 3, 7, 11))
    }
  }

  describe("primeFactorMultiplicity") {
    it(
      "should return the correct prime factor multiplicity for small numbers"
    ) {
      assert(12.primeFactorMultiplicity == List((2, 2), (3, 1)))
      assert(15.primeFactorMultiplicity == List((3, 1), (5, 1)))
      assert(28.primeFactorMultiplicity == List((2, 2), (7, 1)))
    }

    it(
      "should return the correct prime factor multiplicity for prime numbers"
    ) {
      assert(13.primeFactorMultiplicity == List((13, 1)))
      assert(19.primeFactorMultiplicity == List((19, 1)))
    }

    it("should handle large numbers correctly") {
      assert(315.primeFactorMultiplicity == List((3, 2), (5, 1), (7, 1)))
      assert(
        462.primeFactorMultiplicity == List((2, 1), (3, 1), (7, 1), (11, 1))
      )
    }
  }

  describe("primeFactorMultiplicityMap") {
    it(
      "should return the correct prime factor multiplicity as a map for small numbers"
    ) {
      assert(12.primeFactorMultiplicityMap == Map(2 -> 2, 3 -> 1))
      assert(15.primeFactorMultiplicityMap == Map(3 -> 1, 5 -> 1))
      assert(28.primeFactorMultiplicityMap == Map(2 -> 2, 7 -> 1))
    }

    it(
      "should return the correct prime factor multiplicity as a map for prime numbers"
    ) {
      assert(13.primeFactorMultiplicityMap == Map(13 -> 1))
      assert(19.primeFactorMultiplicityMap == Map(19 -> 1))
    }

    it("should handle large numbers correctly") {
      assert(315.primeFactorMultiplicityMap == Map(3 -> 2, 5 -> 1, 7 -> 1))
      assert(
        462.primeFactorMultiplicityMap == Map(2 -> 1, 3 -> 1, 7 -> 1, 11 -> 1)
      )
    }
  }

  describe("listPrimesInRange") {
    it("should return primes within the range 7 to 31") {
      assert(
        S99Int.listPrimesInRange(7 to 31) == List(7, 11, 13, 17, 19, 23, 29, 31)
      )
    }

    it("should return primes within the range 1 to 10") {
      assert(S99Int.listPrimesInRange(1 to 10) == List(2, 3, 5, 7))
    }

    it("should return an empty list when there are no primes") {
      assert(S99Int.listPrimesInRange(0 to 1) == List())
      assert(S99Int.listPrimesInRange(14 to 16) == List())
    }

    it("should include boundaries if they are prime") {
      assert(S99Int.listPrimesInRange(2 to 2) == List(2))
      assert(S99Int.listPrimesInRange(17 to 17) == List(17))
    }

    it("should return empty list for invalid range (start > end)") {
      assert(S99Int.listPrimesInRange(10 to 5) == List())
    }
  }
}
