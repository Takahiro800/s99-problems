package s99

object Problem14 {
  def duplicate[A](list: List[A]): List[A] = {
    list.flatMap(ele => List(ele, ele))
  }
}
