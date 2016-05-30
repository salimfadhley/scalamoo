package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 23/05/16.
  */
class RelationshipTypeSpec extends FlatSpec with Matchers {

  "RelationshipType" should "be namable" in {
    val foo = new RelationshipType(_name = "Above", null, null)
  }

  it should "be alble to create new relationship instances" in {
    val foo = new RelationshipType(_name = "Above", null, null)
    val a:Thing = new Thing("Thing 1")
    val b:Thing = new Thing("Thing 2")
    val rel:Relationship = foo.newRelationship(a,b)
    assert(rel.inverse.b === a)
    assert(rel.inverse.a === b)
  }


  it should "store a reference to i's registry" in {
    val rr = new RelationshipTypeRegistry(name = "RR")
    val foo = new RelationshipType(_name = "Above", null, rr)
    val a:Thing = new Thing("Thing 1")
    val b:Thing = new Thing("Thing 2")
    val rel:Relationship = foo.newRelationship(a,b)
    assert(rel.relationshipType === foo)
    assert(rel.relationshipType.registry === rr)
  }

  it should "identify which is the canonical order of the relationship" in {
    val rr = new RelationshipTypeRegistry(name = "RR")
    val foo = new RelationshipType(_name = "Above", null, rr)
    val a: Thing = new Thing("Thing 1")
    val b: Thing = new Thing("Thing 2")
    val rel: Relationship = foo.newRelationship(a, b)

    withClue("inverse") {
      rel.canonical should be(true)
      rel.inverse.canonical should be(false)
      rel.inverse.inverse.canonical should be(true)
    }

  }

}
