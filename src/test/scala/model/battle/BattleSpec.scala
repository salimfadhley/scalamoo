package model.battle

import model.{Game, Player, Pokemon}
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

  "it" can "be automatically won if the opponent is out of pokemon" in {
    val game = Game.boot()

    val p0: Player = game.spawnPlayer.named("Pootle")
    p0.addPokemon(Pokemon.spawn(game.pokedex, 1))

    val p1: Player = game.spawnPlayer.named("Pootle")
    p1.addPokemon(Pokemon.spawn(game.pokedex, 2))


  }

}
