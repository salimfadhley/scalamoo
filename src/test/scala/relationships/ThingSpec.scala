package relationships

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 24/05/16.
  */
class ThingSpec extends FlatSpec with Matchers {

  "a thing" should "have a name" in {
    val t = new Thing("blob")
    assert(t.name == "blob")
  }

}
