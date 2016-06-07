package relationships

import game.Player
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

  it should "not be equal to other things" in {
    new Thing("A") should not equal new Thing("B")
  }

  it should "be visible when starting with a vowell" in {
    val v:Visible = new Thing("old box")
    v.look(0) should be ("an old box")
  }

  it should "be visible" in {
    val v:Visible = new Thing("box")
    v.look(0) should be ("a box")
  }

  it should "be visible with it's owner's name" in {
    val p = new Player("Jimbob")
    val t:Thing = p.createThing("elephant")
    t.owner === p


    t.look(0) should be ("Jimbob's elephant")
  }

  it should "be storable in a hashset as a unique item" in {
    val a: Thing = new Thing("A")
    val b: Thing = new Thing("B")
    val hs = new scala.collection.mutable.HashSet[Thing]()
    assert(!hs.contains(a))
    assert(!hs.contains(b))
    hs.add(a)

    assert(hs.contains(a))
    assert(!hs.contains(b))

    hs.add(b)

    assert(hs.contains(a))
    assert(hs.contains(b))

  }

}
