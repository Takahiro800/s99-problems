package s99

object S99Int {
  def primeUpTo(n: Int): List[Int] = {
    if (n < 2) return Nil

    val isPrime = Array.fill(n + 1)(true)
    isPrime(0) = false
    isPrime(1) = false

    for (i <- 2 to math.sqrt(n).toInt if isPrime(i)) {
      for (j <- i * i to n by i) {
        isPrime(j) = false
      }
    }

    isPrime.zipWithIndex.collect { case (true, idx) => idx }.toList
  }

  def gcd(m: Int, n: Int): Int = {
    if (n == 0) m else gcd(n, m % n)
  }

  implicit class RichInt(val a: Int) extends AnyVal {
    def isPrime: Boolean = {
      if (a < 2) return false
      else primeUpTo(a).contains(a)
    }

    def isCoprimeTo(b: Int): Boolean = gcd(a, b) == 1

    def totient: Int = (1 to a).filter(a.isCoprimeTo(_)).length

    // Problem34
    def primeFactors: List[Int] = {
      def loop(n: Int, ps: Stream[Int]): List[Int] = {
        if (n.isPrime) List(n)
        else if (n % ps.head == 0) ps.head :: loop(n / ps.head, ps)
        else loop(n, ps.tail) // ストリームを進める
      }

      loop(a, primes)
    }
  }
  lazy val primes: Stream[Int] = 2 #:: Stream.from(3, 2).filter(_.isPrime)
}
