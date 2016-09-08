package world

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 9/8/2016.
  */
class WorldSpec extends FlatSpec with Matchers {

  "world" should "be creatable" in {
    val w: World = new World(0, () => 0)
    assert(w.sn == 0)
  }

  it can "create locations" in {
    val w: World = new World(0, () => 0)
  }

}
