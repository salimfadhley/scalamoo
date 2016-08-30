package parser

import game.{Player, World}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 18/08/2016.
  */
class ParserSpec extends FlatSpec with Matchers {

  "parser" should "exist" in {
    val w = new World("The Earth")
    val pl = new Player("Pootle")
//    val pa = new parser.Parser(world=w, player=pl)
  }


}
