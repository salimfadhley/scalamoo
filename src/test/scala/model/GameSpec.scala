package model

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 12/09/2016.
  */
class GameSpec extends FlatSpec with Matchers {

  "game" should "be bootstrappable" in {
    val g: Game = Game.boot()

  }


}
