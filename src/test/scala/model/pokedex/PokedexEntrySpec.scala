package model.pokedex

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.HashMap

/**
  * Created by salim on 12/09/2016.
  */
class PokedexEntrySpec extends FlatSpec with Matchers {

  "PokedexEntry" can "be created from a map" in {
    val input = HashMap[String, String](
      "id" -> "3",
      "identifier" -> "jeddymon",
      "species_id" -> "3",
      "height" -> "1",
      "weight" -> "1",
      "base_experience" -> "2",
      "order" -> "1",
      "is_default" -> "1"
    )
    val pe = PokedexEntry.fromMap(input)

    assert(pe.id == 3)
    assert(pe.name == "jeddymon")
  }
}
