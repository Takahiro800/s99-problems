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

  // Problem39
  def listPrimesInRange(r: Range): List[Int] = {
    S99Int.primes.dropWhile(_ < r.start).takeWhile(_ <= r.end).toList
  }

  // Problem41
  def goldbachList(r: Range): List[(Int, Int)] = {
    goldbachListLimited(r, 0)
  }

  def goldbachListLimited(r: Range, limit: Int): List[(Int, Int)] = {
    r.filter(n => n > 2 && n % 2 == 0)
      .map(_.goldbach)
      .filter((p, _) => p >= limit)
      .toList
  }

  implicit class RichInt(val a: Int) extends AnyVal {
    def isPrime: Boolean = {
      if (a < 2) return false
      else primeUpTo(a).contains(a)
    }

    def isCoprimeTo(b: Int): Boolean = gcd(a, b) == 1

    def totientByP34: Int = {
      (1 to a).filter(a.isCoprimeTo(_)).length
    }

    // Problem37
    def totient: Int = {
      primeFactorMultiplicityMap.foldLeft(1) {
        case (acc, (factor, multiplicity)) =>
          acc * (factor - 1) * Math.pow(factor, multiplicity - 1).toInt
      }
    }

    // Problem34
    def primeFactors: List[Int] = {
      def loop(n: Int, ps: Stream[Int]): List[Int] = {
        if (n == 1) Nil
        else if (n.isPrime) List(n)
        else if (n % ps.head == 0) ps.head :: loop(n / ps.head, ps)
        else loop(n, ps.tail) // ストリームを進める
      }

      loop(a, primes)
    }

    def primeFactorMultiplicity: List[(Int, Int)] = {
      Problem13.encodeDirect(primeFactors).map(_.swap)
    }

    def primeFactorMultiplicityMap: Map[Int, Int] = {
      primeFactorMultiplicity.toMap
    }

    // Problem40
    def goldbach: (Int, Int) = {
      require(
        a > 2 && a % 2 == 0,
        "Argument must be an even integer greater than 2"
      )

      primes.takeWhile { _ < a }.find { p => (a - p).isPrime } match {
        case None     => throw new IllegalArgumentException
        case Some(p1) => (p1, a - p1)
      }
    }
  }

  lazy val primes: Stream[Int] = 2 #:: Stream.from(3, 2).filter(_.isPrime)
}
