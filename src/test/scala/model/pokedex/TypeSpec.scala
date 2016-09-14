package model.pokedex

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 13/09/2016.
  */
class TypeSpec extends FlatSpec with Matchers {

  "PokemoTypes" should "be able to load csv" in {
    val input =
      """id,identifier,generation_id,damage_class_id
        |1,normal,1,2
        |2,fighting,1,2
        |3,flying,1,2
        |4,poison,1,2"""


  }

}
