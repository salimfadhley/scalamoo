package model

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 16/09/2016.
  */
class PlayerSpec extends FlatSpec with Matchers {

  "Player" should "be able to add pokemon" in {

    val game = Game.boot()
    val player: Player = game.spawnPlayer.named("Pootle")
    val pikachu = Pokemon.spawn(game.pokedex, 25)

    assert(player.getPokemon == Nil)

    player.addPokemon(pikachu)

    assert(player.getPokemon == List(pikachu))

  }

}
