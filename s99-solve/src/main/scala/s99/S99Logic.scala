package s99

class S99Logic(a: Boolean) {
  import S99Logic._

  def and(b: Boolean): Boolean = {
    (a, b) match {
      case (true, true) => true
      case _            => false
    }
  }

  def or(b: Boolean): Boolean = {
    (a, b) match {
      case (true, _) => true
      case (_, true) => true
      case _         => false
    }
  }

  def equ(b: Boolean): Boolean = a.and(b).or(not(a).and(not(b)))
  def xor(b: Boolean): Boolean = not(equ(b))
  def nor(b: Boolean): Boolean = not(or(b))
  def nand(b: Boolean): Boolean = not(and(b))
  def impl(b: Boolean): Boolean = not(a).or(b)

}

object S99Logic {
  implicit def boolean2S99Logic(a: Boolean): S99Logic = new S99Logic(a)

  def not(a: Boolean): Boolean = {
    a match {
      case true  => false
      case false => true
    }
  }
  def table2(f: (Boolean, Boolean) => Boolean) = {
    println("A   B    result")
    for {
      a <- List(true, false)
      b <- List(true, false)
    } yield {
      printf("%-5s %-5s %-5s\n", a, b, f(a, b))
    }
  }
}
