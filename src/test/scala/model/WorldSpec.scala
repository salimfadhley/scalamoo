package model

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 9/8/2016.
  */
class WorldSpec extends FlatSpec with Matchers {

  "world" should "be creatable" in {
    val w: World = new World(0, () => 0)
    assert(w.sn == 0)
  }

  it should "have a factory" in {
    val w: World = World.factory(snGenratorFactory())
    assert(w.sn == 0)
  }

  it can "create locations" in {
    val w: World = World.factory(snGenratorFactory())
    w.newRoom.setName("The very first room.")
  }

}
