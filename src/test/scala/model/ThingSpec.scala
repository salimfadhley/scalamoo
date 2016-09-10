package model

import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

/**
  * Created by salim on 9/9/2016.
  */
class Thingpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  var w: World = null
  var r: Room = null
  var t: Thing = null

  override def beforeEach(): Unit = {
    super.beforeEach()
    w = World.factory()
    r = w.newRoom
    t = r.newThing
  }

  "Things" should "be namable" in {
    r.setName("The First Room")
    assert(r.name.get == "The First Room")
  }

  it should "be retrievable by id" in {
    assert(r.getById(t.sn).get == t)
  }

  it can "be taken out from a room" in {
    assert(r.getById(t.sn).get == t, "Initially the thing is in the loccation")
    assert(t.containerId.get == r.sn, "And it has a reference back to the location")
    r.remove(t.sn)
    assert(r.getById(t.sn).isEmpty, "Thing should bot be in the old location")
    assert(t.containerId.isEmpty, "Thing should have no reference to a container since it has been removed")
  }

  it can "be taken out from a room without knowin the sn" in {
    assert(r.getById(t.sn).get == t, "Initially the thing is in the loccation")
    assert(t.containerId.get == r.sn, "And it has a reference back to the location")
    r.remove(t)
    assert(r.getById(t.sn).isEmpty, "Thing should not be in the old location")
    assert(t.containerId.isEmpty, "Thing should have no reference to a container since it has been removed")
  }

  it can "throw an error if you try to add an item to a second room" in {
    val r1 = w.newRoom
    intercept[AlreadyInAContainer](
      r1.put(t)
    )
  }

  it can "being added to the same room as a no-op" in {
    r.put(t)
  }

  it can "transfer a thing from one room to another" in {
    val r1 = w.newRoom
    r1.put(r.remove(t.sn).get)
    assert(r1.sn == t.containerId.get)
  }



  //  "it" should "be gettable by path" in {
  //    val path = List(r.sn, t.sn)
  //    assert(w.getByPath(path) == t)
  //  }


}
