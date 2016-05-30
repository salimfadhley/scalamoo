package game

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 28/05/16.
  */
class WorldSpec extends FlatSpec with Matchers {

  "The World" should "be creatable" in {
    val w = new World("The Earth")
  }

  it can "contain locations" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")
    l0.registry should be(l0.registry)
    l0.registry.name should be(l0.registry.name)
    l0.world should be(w)
  }

  it can "contain multiple locations related by direction" in {
    val w = new World("The Earth")
    w.registry.createRelationshipPairs("North", "South")
    val l0: Location = w.newLocation("The First Room")
    val l1: Location = w.newLocation("The second Room")
    w.relate(l0, l1, "North") // means l0 is north of l1

    l0.exits.toList should have length 1
    l1.exits.toList should have length 1

    l0.exits.toList(0).direction should be(w.registry.getByName("South"))
    l0.exits.toList(0).to should be(l1)

    l1.exits.toList(0).direction should be(w.registry.getByName("North"))
    l1.exits.toList(0).to should be(l0)


  }

}
