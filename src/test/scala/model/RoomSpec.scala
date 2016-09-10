package model

import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

/**
  * Created by salim on 9/9/2016.
  */
class RoomSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  var w: World = null
  var r: Room = null

  override def beforeEach(): Unit = {
    super.beforeEach()
    w = World.factory()
    r = w.newRoom
  }

  "Room" should "be namable" in {
    r.setName("The First Room")
    assert(r.name.get == "The First Room")
  }

}
