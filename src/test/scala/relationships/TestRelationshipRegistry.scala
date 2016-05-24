package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 09/05/16.
  */
class RelationshipRegistrySpec extends FlatSpec with Matchers {

  "A relationships.RelationshipRegistry" should "be creatable" in {
    new RelationshipRegistry()
  }

  it should "be namable" in {
    new RelationshipRegistry(name="Foo")
  }

  it should "have the ability to create new types of relationship" in {
    val rr = new RelationshipRegistry(name="Foo")
    val rp:RelationshipPair = rr.createRelationshipPairs(a="Above", b="Below")
  }

  it should "thow an error when we ask for a relationship that does not exist" in {
    val rr = new RelationshipRegistry(name="Foo")
    intercept[UnknownRelationshipTypeException] {
      rr.getByName("XXX")
    }
  }


  it should "create pairs of inverse relationships" in {
    val rr = new RelationshipRegistry(name="Foo")
    val rp = rr.createRelationshipPairs(a="Above", b="Below")

//    assert(rp.a.inverse == rp.b)
    assert(rp.b.inverse == rp.a)

  }

}
