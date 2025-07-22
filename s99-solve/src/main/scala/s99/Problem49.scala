package s99

object Problem49 {
  import scala.collection.mutable

  def gray(n: Int): List[String] = {
    if (n == 0) List("")
    else {
      val lower = gray(n - 1)
      (lower.map { "0" + _ }) ::: (lower.reverse.map { "1" + _ })
    }
  }

  private val memo: mutable.Map[Int, List[String]] = mutable.Map(
    0 -> List(""),
    1 -> List("0", "1")
  )

  def grayMemoized(n: Int): List[String] = {
    memo.getOrElseUpdate(
      n, {
        val lower = grayMemoized(n - 1)
        lower.map { "0" + _ } ::: lower.reverse.map { "1" + _ }
      }
    )
  }
}
