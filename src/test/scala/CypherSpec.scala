import org.scalatest.{MustMatchers, WordSpec}

class CypherSpec extends WordSpec with MustMatchers {

  "Cypher" when {

    "getCorrespondingNumbers is called" must {

      "return 1, 26 for a, z" in {
        Cypher.getCorrespondingNumbers("az") mustEqual List(1,26)
      }

    }

    "encode is called" must {

      "return 7 for 5 with a key of 2" in {
        Cypher.encode("e", 2) mustEqual List(7)
      }

      "return 20, 12, 18, 30, 21 for 19, 3, 15, 21, 20 with a key of 1939" in {
        Cypher.encode("scout", 1939) mustEqual List(20,12,18,30,21)
      }
    }

    "decode is called" must {

      "return scout for [ 20, 12, 18, 30, 21], 1939" in {
        Cypher.decode(List(20,12,18,30,21), 1939) mustEqual "scout"
      }


      "return masterpiece for [ 14, 10, 22, 29, 6, 27, 19, 18, 6, 12, 8], 1939" in {
        Cypher.decode(List(14, 10, 22, 29, 6, 27, 19, 18, 6, 12, 8), 1939) mustEqual "masterpiece"
      }

      "return fishing for [9, 13, 22, 12, 12, 18, 10], 34" in {
        Cypher.decode(List(9, 13, 22, 12, 12, 18, 10), 34) mustEqual "fishing"
      }

    }

  }

}
