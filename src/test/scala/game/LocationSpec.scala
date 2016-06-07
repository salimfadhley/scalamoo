package game

import org.scalatest.{FlatSpec, Matchers}
import relationships.Visible

/**
  * Created by sal on 28/05/16.
  */
class LocationSpec extends FlatSpec with Matchers {

  "Location" should "be namable" in {
    val w = new World("Ooo")
    val l = new Location("The First Room", w)
  }

  it should "be able to retrieve other locations by relationship name" in {
    val w:World = World.bootstrap("The Earth")
    val locations:List[String] = List("A", "B", "C", "D")
    val ll:List[Location] = Location.locationFactory(w, locations)

    val roomA = ll.head
    val roomB = ll(1)
    val roomC = ll(2)
    val roomD = ll(3)

    w.relate(roomA, roomB, "North") // A is North of B
    w.relate(roomA, roomC, "South") // A is South of C
    w.relate(roomA, roomD, "East") //  A is East of D

    val result0:List[Location] = w.getRelated(roomA, "South").toList
    assert(result0.contains(roomB))
    result0 should have length 1

    val result1:List[Location] = w.getRelated(roomA, "West").toList
    assert(result1.contains(roomD))
    result1 should have length 1
  }

  it should "be visible"  in {
    val w:World = World.bootstrap("Meh")
    val l:Visible = w.newLocation("A")
    l.look(0).shouldEqual("A")
  }

}
