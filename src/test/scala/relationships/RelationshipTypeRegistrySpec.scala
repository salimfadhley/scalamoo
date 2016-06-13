package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 09/05/16.
  */
class RelationshipTypeRegistrySpec extends FlatSpec with Matchers {

  "A relationships.RelationshipRegistry" should "be creatable" in {
    new RelationshipTypeRegistry()
  }

  it should "be namable" in {
    new RelationshipTypeRegistry(name = "Foo")
  }

  it should "have the ability to create new types of relationship" in {
    val rr = new RelationshipTypeRegistry(name = "Foo")
    val rp: RelationshipTypePair = rr.createRelationshipPairs(a = "Above", b = "Below")
  }

  it should "thow an error when we ask for a relationship that does not exist" in {
    val rr = new RelationshipTypeRegistry(name = "Foo")
    intercept[UnknownRelationshipTypeException] {
      rr.getByName("XXX")
    }
  }


  it should "create pairs of inverse relationships" in {
    val rr = new RelationshipTypeRegistry(name = "Foo")
    val rp = rr.createRelationshipPairs(a="Above", b="Below")
    assert(rp.a.inverse == rp.b)
    assert(rp.b.inverse == rp.a)
  }

  it should "be able to retrieve a relationship by name" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val ab: RelationshipTypePair = rr.createRelationshipPairs("Above", "Below")
    ab.a should be(rr.getByName("Above"))
    ab.b should be(rr.getByName("Below"))
  }

  it should "remember previously generated relationships" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val ab0: RelationshipTypePair = rr.createRelationshipPairs("Above", "Below")
    val ab1: RelationshipTypePair = rr.createRelationshipPairs("Above", "Below")
    ab0.a should be(ab1.a)
    ab0.b should be(ab1.b)
  }

  it should "prevent previously generated relationships from being redefined" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val ab0: RelationshipTypePair = rr.createRelationshipPairs("Above", "Below")

    intercept[RedefinitionOfRelationshipException] {
      val ab1: RelationshipTypePair = rr.createRelationshipPairs("Above", "XXXX")
    }
  }

  it should "prevent previously generated inverse relationships from being redefined" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val ab0: RelationshipTypePair = rr.createRelationshipPairs("Above", "Below")

    intercept[RedefinitionOfRelationshipException] {
      val ab1: RelationshipTypePair = rr.createRelationshipPairs("XXXX", "Below")
    }
  }


}
