package battle

import model.{Game, Player}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 12/09/2016.
  */
class BattleSpec extends FlatSpec with Matchers {

  "Battles" can "be started" in {
    val g: Game = Game.boot()


    val p0 = new Player(0).named("Ash")



    val p1 = new Player(1).named("Garry")
    val b: Battle = new Battle(p0, p1)

  }

}
