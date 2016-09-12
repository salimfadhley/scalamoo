package model.monsters

import java.io.{ByteArrayInputStream, InputStream}

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 12/09/2016.
  */
class PokedexSpec extends FlatSpec with Matchers {
  "Pokedex" should "be creatable" in {
    val p: Pokedex = new Pokedex()
  }

  it should "be possible to load data from a resource" in {
    val pokedexStreams: InputStream = getClass.getResourceAsStream("/pokedex/pokedex/data/csv/pokemon.csv")
    val p: Pokedex = new Pokedex()
    p.loadFromStream(pokedexStreams)
  }

  it should "be able to decode pokedex entries" in {
    val p: Pokedex = new Pokedex()
    val input: String =
      """id,identifier,species_id,height,weight,base_experience,order,is_default
        |1,bulbasaur,1,7,69,64,1,1"""

    p.loadFromStream(new ByteArrayInputStream(input.getBytes))
  }

}
