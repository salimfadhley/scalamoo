package model.battle

import model.Game
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 12/09/2016.
  */
class BattleSpec extends FlatSpec with Matchers {
  "Battles" can "be started" in {
    val g: Game = Game.boot()
    val p0 = g.spawnPlayer.named("Ash")
    val p1 = g.spawnPlayer.named("Garry")
    val b: Battle = new Battle(p0, p1)
  }

}
