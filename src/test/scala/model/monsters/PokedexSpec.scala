package model.monsters

import java.io.InputStream

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
}
