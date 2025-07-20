package s99

object Problem38 {
  import S99Int._

  def time[A](label: String)(block: => A): A = {
    val now = System.currentTimeMillis()
    val ret = block
    println(label + ": " + (System.currentTimeMillis() - now) + "ms.")
    ret
  }

  def test(n: Int) = {
    time("Preload primes") {
      primes.takeWhile(_ <= Math.sqrt(n)).force
    }
    time("P34 (" + n + ")") {
      n.totientByP34
    }
    time("P37 (" + n + ")") {
      n.totient
    }
  }

  // scala> import s99.Problem38
  //      | Problem38.test(10090)
  // Preload primes: 1ms.
  // P34 (10090): 3ms.
  // P37 (10090): 12ms.
  // val res1: Int = 4032
  //
  // scala> import s99.Problem38
  //      | Problem38.test(10090)
  // Preload primes: 0ms.
  // P34 (10090): 2ms.
  // P37 (10090): 11ms.
  // val res2: Int = 4032
  //
  // scala> import s99.Problem38
  //      | Problem38.test(10090)
  // Preload primes: 0ms.
  // P34 (10090): 2ms.
  // P37 (10090): 9ms.
  // val res3: Int = 4032
  //
  // scala> import s99.Problem38
  //      | Problem38.test(10090)
  // Preload primes: 1ms.
  // P34 (10090): 2ms.
  // P37 (10090): 7ms.
  // val res4: Int = 4032
  //
  // scala> import s99.Problem38
  //      | Problem38.test(10090)
  // Preload primes: 0ms.
  // P34 (10090): 2ms.
  // P37 (10090): 9ms.
  // val res5: Int = 4032
}
