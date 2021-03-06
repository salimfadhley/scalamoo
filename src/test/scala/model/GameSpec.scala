package model

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 12/09/2016.
  */
class GameSpec extends FlatSpec with Matchers {

  "game" should "be bootstrappable" in {
    val g: Game = Game.boot()
  }

  it should "have a bootstrapped pokedex" in {
    val g: Game = Game.boot()
    assert(g.pokedex.getPokedexEntriesById(25).get.name == "pikachu")
  }


}
