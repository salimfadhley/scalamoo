package game

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sal on 28/05/16.
  */
class LocationSpec extends FlatSpec with Matchers {

  "Location" should "be namable" in {
    val w = new World("Ooo")
    val l = new Location("The First Room", w)
  }

  it should "be able to retrieve other locations by relationship name" in {
    val w = new World("The Earth")
    val locations:List[String] = List("A", "B", "C", "D")
    val ll:List[Location] = Location.locationFactory(w, locations)

    val roomA = ll.head
    val roomB = ll(1)
    val roomC = ll(2)
    val roomD = ll(3)


  }

}
