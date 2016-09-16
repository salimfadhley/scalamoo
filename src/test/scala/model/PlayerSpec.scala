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

    val bulbasaur = Pokemon.spawn(game.pokedex, 1)
    val ivysaur = Pokemon.spawn(game.pokedex, 2)
    val venusaur = Pokemon.spawn(game.pokedex, 3)
    val charmander = Pokemon.spawn(game.pokedex, 4)
    val charmeleopn = Pokemon.spawn(game.pokedex, 5)
    val charizard = Pokemon.spawn(game.pokedex, 6)
    val squirtle = Pokemon.spawn(game.pokedex, 7)

    player.addPokemon(bulbasaur)
    player.addPokemon(ivysaur)
    player.addPokemon(venusaur)
    player.addPokemon(charmander)
    player.addPokemon(charmeleopn)
    player.addPokemon(charizard)

    intercept[PokemonLimitReached](
      player.addPokemon(squirtle)
    )

  }

  //  1,bulbasaur,1,7,69,64,1,1
  //  2,ivysaur,2,10,130,142,2,1
  //  3,venusaur,3,20,1000,236,3,1
  //  4,charmander,4,6,85,62,5,1
  //  5,charmeleon,5,11,190,142,6,1
  //  6,charizard,6,17,905,240,7,1
  //  7,squirtle,7,5,90,63,10,1



}
