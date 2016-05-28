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

  it can "have a proptotype" in {
    val prototype = new Prototype("pen")
    val t = new Thing("Salim's pen", prototype)
  }

  it should "have a serial number" in {
    val sn: Int = new Thing("Salim's pen").sn
  }

  it should "have a unique serial number" in {
    withClue("Serial Number") {
      new Thing("Salim's pen").sn should not equal new Thing("Salim's book").sn
    }
  }

}
