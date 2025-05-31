package s99

object Problem07 {
  def flatten(list: List[Any]): List[Any] = {
    list flatMap {
      case nested: List[_] => flatten(nested)
      case ele             => List(ele)
    }
  }
}
