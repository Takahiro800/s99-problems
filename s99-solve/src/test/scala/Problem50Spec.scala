import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import s99.Problem50

class Problem50Spec extends AnyFunSpec with Matchers {
  describe("Problem50.huffman") {
    it("should produce the correct Huffman codes for the given frequencies") {
      val input = List(
        ("a", 45),
        ("b", 13),
        ("c", 12),
        ("d", 16),
        ("e", 9),
        ("f", 5)
      )

      val result = Problem50.huffman(input).toMap

      // 結果はエンコードのパターンは一意ではないが、以下の条件を満たす必要がある
      // - 各要素にユニークなプレフィックスコードが割り当てられている
      // - 頻度が高い文字ほどコードが短い（最短とは限らないが）

      // 最低限の条件: 結果のキー集合が同じであること
      result.keySet shouldEqual input.map(_._1).toSet

      // プレフィックスコードであることの確認
      val codes = result.values.toList
      all(codes) should fullyMatch regex "[01]+"

      // どのコードも他のコードの接頭辞になっていない（プレフィックス性）
      for {
        c1 <- codes
        c2 <- codes if c1 != c2
      } {
        c2.startsWith(c1) shouldBe false
      }

      // 頻度が高いほどコードが短い傾向にあること（参考用）
      val lengthsByFreq = input.sortBy(-_._2).map(_._1).map(result(_).length)
      all(lengthsByFreq.init.zip(lengthsByFreq.tail).map { case (a, b) =>
        a <= b
      }) shouldBe true
    }

    it("should return a single code '0' for a single element input") {
      val input = List(("only", 1))
      Problem50.huffman(input) shouldEqual List(("only", "0"))
    }
  }
}
