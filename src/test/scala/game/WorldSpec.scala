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
    l0.registry.name should be(l0.registry.name)
    l0.world should be(w)
  }

  it can "contain multiple locations related by direction" in {
    val w = new World("The Earth")
    w.registry.createRelationshipPairs("North", "South")
    val l0: Location = w.newLocation("The First Room")
    val l1: Location = w.newLocation("The second Room")
    w.relate(l0, l1, "North") // means l0 is north of l1

    l0.exits.toList should have length 1
    l1.exits.toList should have length 1

    l0.exits.head.direction should be(w.registry.getByName("South"))
    l0.exits.head.to should be(l1)

    l1.exits.head.direction should be(w.registry.getByName("North"))
    l1.exits.head.to should be(l0)
  }

  it can "have a default location" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val l1: Location = w.newLocation("The Second Room")
    w.add(l0)
    w.add(l1)
    w.defaultLocation shouldEqual Some(l0)
  }

  it can "have a default location changed" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val l1: Location = w.newLocation("The Second Room")
    w.add(l0)
    w.add(l1)
    w.setDefaulLocation(l1)
    w.defaultLocation shouldEqual Some(l1)
  }

  it can "new players are added to the default location" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val l1: Location = w.newLocation("The Second Room")
    val p0: Player = new Player("Hank")
    w.add(l0)
    w.add(l1)
    w.setDefaulLocation(l1)
    w.addPlayer(p0)

    withClue("Location players") {
      l0.players should have size 0
      l1.players should have size 1
    }

    withClue("World players") {
      w.players should have size 1
      assert(w.players.toSet.contains(p0))
    }
  }

  it can "players can be removed from locations" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val p0: Player = new Player("JimBob")
    w.add(l0)
    w.addPlayer(p0)

    withClue("Location players") {
      l0.players should have size 1
    }
  }

  it can "players can be removed from locations to another" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val l1: Location = w.newLocation("The Second Room")
    val p0: Player = new Player("JimBob")
    w.add(l0)
    w.add(l1)
    w.addPlayer(p0)
    p0.location match {
      case Some(l: Location) =>
      case _ => fail("Original location was wrong")
    }
    val pp: Player = w.movePlayer(p0, l1)

    p0.location should be(Some(l1))
    l1.players.valuesIterator.toSet should contain(p0)
    }

  it can "move a player to a relative location" in {
    val w = World.bootstrap("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val l1: Location = w.newLocation("The Second Room")
    val l2: Location = w.newLocation("The Second Room")
    val l3: Location = w.newLocation("The Third Room")

    w.relate(l0, l1, "North") // l0 is North of l1
    w.relate(l1, l2, "East") // l1 is east of L2
    w.relate(l3, l2, "South") // L3 is south of L2

    val p:Player = w.addPlayer(new Player("JimBob"))

    w.movePlayer(p, "South")
    p.location shouldBe Some(l1)

    w.movePlayer(p, "West")
    p.location shouldBe Some(l2)

    w.movePlayer(p, "South")
    p.location shouldBe Some(l3)
  }

  it can "it throws a NoSuchDirection error if we try to move to a non-existent direction" in {
    val w = World.bootstrap("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val p: Player = w.addPlayer(new Player("JimBob"))

    intercept[NoSuchDirection] {
      w.movePlayer(p, "South")
    }

    p.location shouldBe Some(l0)
  }

  it can "throw an exception when we attempt to remove a player from a location that does not exist" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")

    val p0: Player = new Player("JimBob")
    w.add(l0)
    w.addPlayer(p0)
    intercept[NoSuchPlayer] {
      val pp: Player = w.takePlayer(p0.sn+ 999, l0.sn )
    }
  }

  it can "throw an exception when we attempt to remove a player that does not exist from a location" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val p0: Player = new Player("JimBob")
    w.add(l0)
    w.addPlayer(p0)
    intercept[NoSuchLocation] {
      val pp: Player = w.takePlayer(p0.sn, l0.sn + 999)
    }
  }

  it can "throw an error when users are added to the world without locations" in {
    val w = new World("The Earth")
    val p0: Player = new Player("Hank")

    intercept[CannotAddPlayer] {
      w.addPlayer(p0)
    }
  }

  it can "allow players to move between locations" in {
    val w = new World("The Earth")
    val l0: Location = w.newLocation("The First Room")
    val l1: Location = w.newLocation("The Second Room")
    w.registry.createRelationshipPairs("North", "South")
    val p0: Player = new Player("Hank")

    w.relate(l0, l1, "North") // l0 is north of l1
    w.addPlayer(p0)
    p0.location match {
      case Some(l:Location) => assert(l==l0)
      case _ => throw new RuntimeException("unexpected!")
    }

    l0.contains(p0) should be(true)
    l1.contains(p0) should be(false)

    // Now move the player

    p0.moveDirection("North")

//    l0.contains(p0) should be(false)
//    l1.contains(p0) should be(true)
  }


}
