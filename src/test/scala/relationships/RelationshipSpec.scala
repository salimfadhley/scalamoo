package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 28/05/16.
  */
class RelationshipSpec extends FlatSpec with Matchers {

  "Relationship" should "have a serial number" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val rp = rr.createRelationshipPairs("A", "B")
    val r: Relationship = rp.a.newRelationship(null, null)
    val sn: Int = r.sn
  }

  "Relationship" should "have a unique serial number" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val rp = rr.createRelationshipPairs("A", "B")
    val r0: Relationship = rp.a.newRelationship(null, null)
    val r1: Relationship = rp.a.newRelationship(null, null)

    withClue("Serial Number") {
      r0.sn should not be (r1.sn)
    }
  }

}
