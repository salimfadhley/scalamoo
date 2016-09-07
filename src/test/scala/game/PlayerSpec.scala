package game

import org.scalatest.{Assertions, FlatSpec, Matchers}
import relationships.{Observer, Thing}

/**
  * Created by salim on 04/06/2016.
  */
class PlayerSpec extends FlatSpec with Matchers with Assertions {

  "Player" should "be able to look at a void" in {
    val p:Observer = new Player("Hank")
    assert(p.look(0) === "You are in a formless void.")
  }

  it should "be able to look at a location" in {
    val w:World = World.bootstrap("Planet X")
    val l:Location = w.newLocation("bedroom")
    val p:Player = new Player("Hank")
    l.addPlayer(p)
    assert(p.look(0) === "You are in a bedroom.")
  }

  it should "be able to look at a location containing related stuff" in {
    val w:World = World.bootstrap("Planet X")
    val l:Location = w.newLocation("bedroom")
    val p:Player = new Player("Hank")

    val t0:Thing = new Thing("bucket")
    val t1:Thing = new Thing("matress")

    l.relate(t0, t1, "On")

    l.addPlayer(p)
    assert(p.look(0) === "You are in a bedroom. A bucket is on a matress.")
  }

  it should "fail if we try to move to an invalid location" in {
    val w:World = World.bootstrap("Mario Land")

    val l0 = w.newLocation("Attic")
    val p: Player = new Player("Ash")
    w.addPlayer(p)

    intercept[NoWayOut] {
      p.moveDirection("n")
    }





  }

}
