package model.pokedex

import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

/**
  * Created by salim on 12/09/2016.
  */
class PokedexSpec extends FlatSpec with Matchers {
  "Pokedex" should "be creatable" in {
    val p: Pokedex = new Pokedex()
  }

  it should "be possible to load data from a resource" in {
    val p: Pokedex = new Pokedex()


    Pokedex.openStreamAndLoad("pokemon", p.addPokedexEntry)

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

  it should "be able to decode pokedex entries" in {
    val p: Pokedex = new Pokedex()
    val input: String =
      """id,identifier,species_id,height,weight,base_experience,order,is_default
        |1,bulbasaur,1,7,69,64,1,1""".stripMargin
    Pokedex.loadItemsFromSource(p.addPokedexEntry, Source.fromString(input))
    val bulbasaur: PokedexEntry = p.getPokedexEntriesById(1).get
  }

  it should "be able to decode pokedex single line loads" in {
    val p: Pokedex = new Pokedex()
    val input: String =
      """id,identifier,species_id,height,weight,base_experience,order,is_default
        |1,bulbasaur,1,7,69,64,1,1""".stripMargin
    Pokedex.loadItemsFromSource(p.addPokedexEntry, Source.fromString(input))
    val bulbasaur: PokedexEntry = p.getPokedexEntriesById(1).get
    assert(bulbasaur.id == 1)
    assert(bulbasaur.name == "bulbasaur")
  }

  it should "be able to decode pokedex multi line loads" in {
    val p: Pokedex = new Pokedex()
    val input: String =
      """id,identifier,species_id,height,weight,base_experience,order,is_default
        |1,bulbasaur,1,7,69,64,1,1
        |10,caterpie,10,3,29,39,14,1""".stripMargin

    Pokedex.loadItemsFromSource(p.addPokedexEntry, Source.fromString(input))

    val catarpie: Option[PokedexEntry] = p.getPokedexEntriesById(10)
    assert(catarpie.get.id == 10)
  }

  it should "be able to get types for pokemon" in {
    val pokedex = Pokedex.boot

    val e: Type = pokedex.getType(13).get
    assert(e.identifier == "electric")
    val pikachu: PokedexEntry = pokedex.getPokedexEntriesById(25).get

    assert(pikachu.getType(pokedex) == e)

  }

}
