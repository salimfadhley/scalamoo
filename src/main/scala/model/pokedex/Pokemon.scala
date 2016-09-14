package model.pokedex

import model.Namable
import model.battle.Battleable

/**
  * Created by salim on 12/09/2016.
  */
class Pokemon(pokedexEntry: PokedexEntry) extends Battleable with Namable[Pokemon] {
  override var maxHitPoints: Int = 1
}

object Pokemon {

}
