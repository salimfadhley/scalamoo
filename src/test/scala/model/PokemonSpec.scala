package model

import model.pokedex.{Pokedex, Pokemon}
import org.scalatest.FlatSpec

/**
  * Created by salim on 16/09/2016.
  */
class PokemonSpec extends FlatSpec {

  "Pokemon" should "be creatable by id" in {
    val pokedex: Pokedex = Pokedex.boot
    val p: Pokemon = Pokemon.spawn(pokedex, 25).named("Foofoo")

    assert(p.name.get == "Foofoo")
    assert(p.pokedexEntry.name == "pikachu")


  }

}
