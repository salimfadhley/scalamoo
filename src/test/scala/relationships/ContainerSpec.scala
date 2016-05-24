package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 24/05/16.
  */
class ContainerSpec extends FlatSpec with Matchers {

  "Container" should "Be able to contain Things" in {
    val t = new Thing("foo")
    val c = new Container()
    c.add(t)
    assert(c.contains(t)==true)
  }

  "Container" should "only contain objects that were stored in the container" in {
    val t = new Thing("foo")
    val c = new Container()
    assert(c.contains(t)==false)
  }

}
