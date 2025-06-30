package s99

object Problem28 {
  def lsort[A](ls: List[List[A]]): List[List[A]] = {
    ls.sortBy(_.length)
  }

  def lsortFreq[A](ls: List[List[A]]): List[List[A]] = {
    val freqMap: Map[Int, Int] =
      ls.groupBy(_.length).view.mapValues(_.size).toMap

    ls.sortBy(list => freqMap(list.length))
  }
}
