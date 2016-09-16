package model.pokedex

import model.Namable
import model.battle.Battleable

/**
  * Created by salim on 12/09/2016.
  */
case class Pokemon(pokedexEntry: PokedexEntry) extends Battleable with Namable[Pokemon] {



  override var maxHitPoints: Int = 1
}

object Pokemon {
  def spawn(implicit pokedex: Pokedex, pokemom_id: Int): Pokemon = {
    pokedex.getPokedexEntriesById(pokemom_id) match {
      case None => throw new InvalidPokemonError(s"Pokemon id $pokemom_id is invalid")
      case Some(pe: PokedexEntry) => new Pokemon(pe)
    }
  }

}
