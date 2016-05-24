package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 23/05/16.
  */
class RelationshipTypeSpec extends FlatSpec with Matchers {

  "RelationshipType" should "be namable" in {
    val foo = new RelationshipType(name="Above", "below", null)
  }

  it should "be alble to create new relationship instances" in {
    val foo = new RelationshipType(name="Above", "below", null)

    val a:Thing = new Thing("Thing 1")
    val b:Thing = new Thing("Thing 2")

    val rel:Relationship = foo.newRelationship(a,b)

    assert(rel.inverse.b == a)
    assert(rel.inverse.a == b)
  }

}
