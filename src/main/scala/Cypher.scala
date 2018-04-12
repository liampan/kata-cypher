object Cypher {

  val zipped: Map[Char, Int] = ('a' to 'z').zip(1 to 26).toMap
  val swapped: Map[Int, Char] = zipped.map(_.swap)

  def getCorrespondingNumbers(word: String): List[Int] = word.map(zipped(_)).toList

  def extendKey(size: Int, key: Int): List[Int] = {
    List.fill(size)(key).map(_.toString).mkString.take(size).toList.map(_.asDigit)
  }

  def encode(word: String, key: Int): List[Int] = {
    getCorrespondingNumbers(word).zip(extendKey(word.length, key)).map(x => x._1 + x._2)
  }

  def decode(encodedWord: List[Int], key: Int): String = {
    encodedWord.zip(extendKey(encodedWord.length, key)).map(x => x._1 - x._2).map(swapped).mkString
  }

}
