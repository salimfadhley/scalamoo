package model.monsters

import java.io.InputStream

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
    val is: InputStream = getClass.getResourceAsStream("/pokedex/pokedex/data/csv/pokemon.csv")
    Source.fromInputStream(is)
    val p: Pokedex = new Pokedex()

    // id,identifier,species_id,height,weight,base_experience,order,is_default
    // 691,dragalge,691,18,815,173,774,1
    p.addPokedexEntriesFromSource(Source.fromInputStream(is))

    val pe: PokedexEntry = p.getPokedexEntriesById(691).get

    assert(pe.id == 691)
    assert(pe.name == "dragalge")
    assert(pe.speciesId == 691)
    assert(pe.height == 18)
    assert(pe.weight == 815)
    assert(pe.baseExperience == 173)
    assert(pe.order == 774)
    assert(pe.isDefault == true)



  }

  it should "be able to decode pokedex entries" in {
    val p: Pokedex = new Pokedex()
    val input: String =
      """id,identifier,species_id,height,weight,base_experience,order,is_default
        |1,bulbasaur,1,7,69,64,1,1""".stripMargin
    p.addPokedexEntriesFromSource(Source.fromString(input))
    val bulbasaur: PokedexEntry = p.getPokedexEntriesById(1).get
  }

  it should "be able to decode pokedex single line loads" in {
    val p: Pokedex = new Pokedex()
    val input: String =
      """id,identifier,species_id,height,weight,base_experience,order,is_default
        |1,bulbasaur,1,7,69,64,1,1""".stripMargin
    p.addPokedexEntriesFromSource(Source.fromString(input))
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

    p.addPokedexEntriesFromSource(Source.fromString(input))

    val catarpie: Option[PokedexEntry] = p.getPokedexEntriesById(10)
    assert(catarpie.get.id == 10)
  }

}
