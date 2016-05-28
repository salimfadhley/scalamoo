package game

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 28/05/16.
  */
class LocationSpec extends FlatSpec with Matchers {

  "Location" should "be namable" in {
    val l = new Location("The First Room", null, null)
  }

}
