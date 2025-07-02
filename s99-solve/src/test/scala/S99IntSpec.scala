import org.scalatest.funsuite.AnyFunSuite
import s99.S99Int

class S99IntTest extends AnyFunSuite {

  test("isPrime returns true for known primes") {
    val primes = List(2, 3, 5, 7, 11, 13, 17, 19, 23)
    primes.foreach(p => assert(new S99Int(p).isPrime))
  }

  test("isPrime returns false for non-primes") {
    val nonPrimes = List(1, 4, 6, 8, 9, 10, 12, 15, 20)
    nonPrimes.foreach(n => assert(!new S99Int(n).isPrime))
  }
}
