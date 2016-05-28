package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 24/05/16.
  */
class ContainerSpec extends FlatSpec with Matchers {

  "Container" should "Be able to contain Things" in {
    val t = new Thing("foo")
    val c = new Container("bar", null)
    c.add(t)
    assert(c.contains(t))
  }

  it should "only contain objects that were stored in the container" in {
    val t = new Thing("foo")
    val c = new Container("bar", null)
    assert(!c.contains(t))
  }

  it should "not duplicate items stored twice" in {
    val t = new Thing("foo")
    val c = new Container("bar", null)
    c.add(t)
    c.add(t)
    c.contains(t) should be(true)
  }

  it should "Be able to contain Containers" in {
    val c1 = new Container("x", null)
    val c2 = new Container("z", null)
    val c = new Container("y", null)
    c.add(c1)
    assert(c.contains(c1))
    assert(!c.contains(c2))
  }

  it should "have a reference to a relationship registry" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val c1 = new Container("x", _registry = rr)
    c1.registry should be(rr)
  }

  it should "be possible to add and relate objects in a container" in {
    val rr = new RelationshipTypeRegistry("xxx")
    val c = new Container("x", _registry = rr)
    val t1 = new Thing("Thing 1")
    val t2 = new Thing("Thing 2")
    rr.createRelationshipPairs("Above", "Below")
    val r: Relationship = c.relate(t1, t2, "Above")
    c.getRelationships(t1, t2).toList should contain(r)
    c.getRelationships(t1, t2).toList should have size 1
  }


}
