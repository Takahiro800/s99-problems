package s99

object Problem06 {
  def isPalindrome[A](list: List[A]): Boolean = {
    list == list.reverse
  }
}
