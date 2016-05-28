package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 27/05/16.
  */
class RelationshipPairSpec extends FlatSpec with Matchers {

  "RelationshipPair" should "contain a pair of relationships" in {
    val rp = new RelationshipTypePair(new RelationshipType(null, null, null), new RelationshipType(null, null, null))
  }

  "RelationshipPair" can "be unpacked into a pair of relationships" in {
    val aa = new RelationshipType(null, null, null)
    val bb = new RelationshipType(null, null, null)
    val rp = new RelationshipTypePair(aa, bb)


    val (a: RelationshipType, b: RelationshipType): (RelationshipType, RelationshipType) = rp

  }

}
