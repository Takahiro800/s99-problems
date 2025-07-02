package s99

class S99Int(val start: Int) {
  import S99Int._

  def isPrime: Boolean = {
    if (start < 2) return false
    else primeUpTo(start).contains(start)
  }
}

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
}
