package relationships

import game.{Player, World}
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

  it should "contain both a relationship and its inverse" in {
    val rr = new RelationshipTypeRegistry("xxx")
    rr.createRelationshipPairs("Above", "Below")
    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")
    c.hasRelationship(t1, t2, "Above") should be(true)
    c.hasRelationship(t2, t1, "Below") should be(true)
  }

  it should "be able to reframe a relationship from either object it relates" in {
    val rr = new RelationshipTypeRegistry("xxx")
    rr.createRelationshipPairs("Above", "Below")
    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")

    r0.inverse.fromPerspective(t1) should equal(r0)
    r0.fromPerspective(t2) should equal(r0.inverse)

  }

  it should "know if it relates to objects" in {
    val rr = new RelationshipTypeRegistry("xxx")
    rr.createRelationshipPairs("Above", "Below")
    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val t3 = new Thing("t3")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")

    r0.relatesTo(t1) should be(true)
    r0.relatesTo(t2) should be(true)
    r0.relatesTo(t3) should be(false)
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

  it should "never be similar to relationships involving different objects" in {
    val rr = new RelationshipTypeRegistry("xxx")
    rr.createRelationshipPairs("Above", "Below")
    val t1 = new Thing("t1")
    val t2 = new Thing("t2")
    val t3 = new Thing("t3")
    val c = new Container("xx", rr)
    val r0: Relationship = c.relate(t1, t2, "Above")

    withClue("similar: ") {
      r0.similar(t1, t3, "Above") should be(false)
      r0.similar(t3, t1, "Below") should be(false)
    }
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

  it should "be visible" in {
    val w:World = World.bootstrap("Kitty's palace")
    val t1 = new Thing("pen")
    val t2 = new Thing("desk")
    val l0 = w.newLocation("Happy Place")
    val r0:Observable = l0.relate(t1, t2, "On")

    r0.observe should be ("A pen is on a desk.")
  }

  it should "describe relationships between unique items" in {
    val w:World = World.bootstrap("Kitty's palace")
    val t1 = new Thing("Pen")
    val t2 = new Thing("Desk")
    val l0 = w.newLocation("Happy Place")
    val r0:Observable = l0.relate(t1, t2, "On")
    r0.observe should be ("The Pen is on the Desk.")
  }

  it should "describe relationships between owned items" in {
    val w:World = World.bootstrap("Kitty's palace")
    val p0 = new Player("Anthony")
    val p1 = new Player("Vlad")
    val t0 = p0.createThing("bucket")
    val t1 = p1.createThing("matress")
    val l0 = w.newLocation("Happy Place")
    val r0:Observable = l0.relate(t0, t1, "On")
    r0.observe should be ("Anthony's bucket is on Vlad's matress.")
  }

  it should "describe relationships between owned unique items" in {
    val w:World = World.bootstrap("Kitty's palace")
    val p0 = new Player("Anthony")
    val p1 = new Player("Vlad")
    val t0 = p0.createThing("Incal")
    val t1 = p1.createThing("matress")
    val l0 = w.newLocation("Happy Place")
    val r0:Observable = l0.relate(t0, t1, "On")
    r0.observe should be ("The Incal is on Vlad's matress.")
  }

//  it should "describe relationships between owned unique items in a location" in {
//    val w:World = World.bootstrap("Kitty's palace")
//    val p0 = new Player("Anthony")
//    val p1 = new Player("Vlad")
//    val t0 = p0.createThing("Incal")
//    val t1 = p1.createThing("matress")
//    val l0 = w.newLocation("bedroom")
//    l0.relate(t0, t1, "On")
//    l0.addPlayer(p0)
//
//    p0.look(0) should be ("You are in a Bedroom. The Incal is on Vlad's matress.")
//    p0.look(1) should be ("You are in a Bedroom.")
//  }


}
