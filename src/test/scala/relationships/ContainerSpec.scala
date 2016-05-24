package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 24/05/16.
  */
class ContainerSpec extends FlatSpec with Matchers {

  "Container" should "Be able to contain Things" in {
    val t = new Thing("foo")
    val c = new Container("bar")
    c.add(t)
    assert(c.contains(t)==true)
  }

  "Container" should "only contain objects that were stored in the container" in {
    val t = new Thing("foo")
    val c = new Container("bar")
    assert(c.contains(t)==false)
  }

  "Container" should "Be able to contain Containers" in {
    val c1 = new Container("x")
    val c2 = new Container("z")
    val c = new Container("y")
    c.add(c1)
    assert(c.contains(c1)==true)
    assert(c.contains(c2)==false)
  }

}
