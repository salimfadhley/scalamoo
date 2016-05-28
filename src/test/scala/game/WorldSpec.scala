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
    l0.world should be(w)
  }

}
