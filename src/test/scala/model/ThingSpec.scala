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

  "it" should "be retrievable by id" in {
    assert(r.getById(t.sn).get == t)
  }

  //  "it" should "be gettable by path" in {
  //    val path = List(r.sn, t.sn)
  //    assert(w.getByPath(path) == t)
  //  }


}
