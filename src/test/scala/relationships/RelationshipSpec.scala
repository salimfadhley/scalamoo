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

  it should "have a unique serial number" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val rp = rr.createRelationshipPairs("A", "B")
    val r0: Relationship = rp.a.newRelationship(null, null)
    val r1: Relationship = rp.a.newRelationship(null, null)

    withClue("Serial Number") {
      r0.sn should not be (r1.sn)
    }
  }

  it should "contain both a reltionship and its inverse" in {
    val rr = new RelationshipTypeRegistry("xxx")
    rr.createRelationshipPairs("Above", "Below")
    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")
    c.hasRelationship(t1, t2, "Below") should be(true)
  }

  it should "relationships are always similar identically defined relationships" in {
    val rr = new RelationshipTypeRegistry("xxx")
    rr.createRelationshipPairs("Above", "Below")
    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")

    r0.similar(t1, t2, "Above") should be(true)
    r0.similar(t2, t1, "Below") should be(true)
  }

  it should "be similar identically defined relationships expressed as objects" in {
    val rr = new RelationshipTypeRegistry("xxx")
    rr.createRelationshipPairs("Above", "Below")
    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")
    val r1: Relationship = c.relate(t1, t2, "Above")

    r0.similar(r1) should be(true)
    r1.similar(r0) should be(true)
  }

  it should "be similar to inverse relationships expressed as objects" in {
    val rr = new RelationshipTypeRegistry("xxx")
    rr.createRelationshipPairs("Above", "Below")
    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")

    withClue("Relationship similarity") {
      r0.similar(r0.inverse) should be(true)
    }
  }

  it should "not be similar different types of relationships on the same object" in {
    val rr = new RelationshipTypeRegistry("xxx")

    rr.createRelationshipPairs("Above", "Below")
    rr.createRelationshipPairs("East", "West")

    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")
    val r1: Relationship = c.relate(t1, t2, "West")

    r0.similar(r1) should be(false)
    r1.similar(r0) should be(false)
    r0.similar(r1.inverse) should be(false)
    r1.similar(r0.inverse) should be(false)
  }

}
