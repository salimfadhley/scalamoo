package model

import scala.collection.mutable

/**
  * Created by salim on 12/09/2016.
  */
trait Trainer {

  val pokemon = mutable.MutableList[Pokemon]()

  def addPokemon(p: Pokemon): Unit = {
    pokemon.size match {
      case i: Int if i < 6 => pokemon += p
      case _ => throw new PokemonLimitReached("dddd")
    }
  }

  def getPokemon: List[Pokemon] = {
    pokemon.toIterator.toList
  }


}
