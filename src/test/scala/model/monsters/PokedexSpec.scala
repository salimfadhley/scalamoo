package model.monsters

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 12/09/2016.
  */
class PokedexSpec extends FlatSpec with Matchers {

  "Pokedex" can "be creatable in" {
    val p = new Pokedex()
  }


}
