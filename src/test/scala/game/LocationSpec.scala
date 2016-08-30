package game

import org.scalatest.{FlatSpec, Matchers}
import relationships.{Observable, Thing}

/**
  * Created by sal on 28/05/16.
  */
class LocationSpec extends FlatSpec with Matchers {

  "Location" should "be namable" in {
    val w = new World("Ooo")
    val l = new Location("The First Room", w)
  }

  it should "be able to make locations in a chained operation" in {
    val w:World = World.bootstrap("The Earth")

    w.newLocation("The Attic")
      .newRelatedLocation("Upstairs Landing", "Down")
      .newRelatedLocation("The Hallway", "Down")
      .newRelatedLocation("The Cellar", "Down")

    val hallway:Location = w.getByName("The Hallway").getOrElse(throw new RuntimeException)
    val landing:Location = w.getByName("Upstairs Landing").getOrElse(throw new RuntimeException)

    val result1:List[Location] = w.getRelated(hallway, "Up").toList
    assert(result1.contains(landing))
    result1 should have length 1

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

  it should "be able to observe locations"  in {
    val w:World = World.bootstrap("Meh")
    val l:Observable = w.newLocation("bedroom")
    l.observe.shouldEqual("a bedroom")
  }

  it should "be able to observe unique locations"  in {
    val w:World = World.bootstrap("Meh")
    val l:Observable = w.newLocation("Throne Room")
    l.observe.shouldEqual("the Throne Room")
  }

  it should "be able to iterate through an empty list of the observable objects" in {
    val w:World = World.bootstrap("Meh")
    val l:Observable = w.newLocation("bedroom")
    val result:Iterator[Observable] = l.observeContents
  }

  it should "be able to iterate through all of the observable objects" in {
    val w:World = World.bootstrap("Meh")
    val l:Location = w.newLocation("bedroom")
    val t0 = new Thing("sock")
    val t1 = new Thing("book")
    l.relate(t0,t1, "On")
    val result:Iterator[Observable] = l.observeContents
    val expected = "A sock is on a book."
    assert(result.map(_.observe).mkString(" ")===expected)
  }

  it should "be able to iterate through all unrelated observable contents" in {
    val w:World = World.bootstrap("Meh")
    val l:Location = w.newLocation("bedroom")
    val t0 = new Thing("sock")
    val t1 = new Thing("book")
    val t2 = new Thing("goat")

    l.add(t0)
    l.add(t1)
    l.add(t2)

    val result:Iterator[Observable] = l.observeContents
    val expected = "You can see a book, a goat and a sock."
    assert(result.map(_.observe).mkString(",")===expected)
  }

}
