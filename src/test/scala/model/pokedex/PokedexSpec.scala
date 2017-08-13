package model.pokedex

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 12/09/2016.
  */
class PokedexSpec extends FlatSpec with Matchers {
  "Pokedex" should "be creatable" in {
    val p: Pokedex = new Pokedex()
  }

  it should "be possible to load data from a resource" in {
    val p: Pokedex = new Pokedex()
    val pe: PokedexEntry = p.getPokedexEntriesById(691).get

    assert(pe.id == 691)
    assert(pe.name == "dragalge")
    assert(pe.species_id == 691)
    assert(pe.height == 18)
    assert(pe.weight == 815)
    assert(pe.base_experience == 173)
    assert(pe.order == 774)
    assert(pe.is_default == true)
  }


  it should "be able to get types for pokemon" in {
    val pokedex = Pokedex.boot
    val e: Type = pokedex.getType(13).get
    assert(e.identifier == "electric")
    val pikachu: PokedexEntry = pokedex.getPokedexEntriesById(25).get

    assert(pikachu.getType(pokedex) == e)

  }

}
