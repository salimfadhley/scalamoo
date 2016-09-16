package model.pokedex

/**
  * Created by salim on 16/09/2016.
  */
case class InvalidPokemonError(message: String) extends RuntimeException(message) {

}
