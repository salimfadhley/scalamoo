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

  it should "be able to add no more than 6" in {
    val game = Game.boot()
    val player: Player = game.spawnPlayer.named("Pootle")

    player.addPokemon(Pokemon.spawn(game.pokedex, 1))
    player.addPokemon(Pokemon.spawn(game.pokedex, 2))
    player.addPokemon(Pokemon.spawn(game.pokedex, 3))
    player.addPokemon(Pokemon.spawn(game.pokedex, 4))
    player.addPokemon(Pokemon.spawn(game.pokedex, 5))
    player.addPokemon(Pokemon.spawn(game.pokedex, 6))

    intercept[PokemonLimitReached](
      player.addPokemon(Pokemon.spawn(game.pokedex, 7))
    )
  }

  it should "know if you have at least one battleable pokemon" in {
    val game = Game.boot()
    val player: Player = game.spawnPlayer.named("Pootle")

    player.addPokemon(Pokemon.spawn(game.pokedex, 1))
    player.addPokemon(Pokemon.spawn(game.pokedex, 2))
    player.addPokemon(Pokemon.spawn(game.pokedex, 3))


  }






}
