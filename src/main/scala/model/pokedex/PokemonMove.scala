package model.pokedex

/**
  * Created by salim on 19/09/2016.
  */
case class PokemonMove(pokemon_id: Int, version_group_id: Int, move_id: Int, pokemon_move_method_id: Int, level: Int, order: Int) {

}

object PokemonMove extends DexThing[PokemonMove] {
  def fromMap(row: Map[String, ConvertibleThing]): PokemonMove = {
    PokemonMove(
      row("pokemon_id").i,
      row("version_group_id").i,
      row("move_id").i,
      row("pokemon_move_method_id").i,
      row("level").i,
      row("order").i
    )
  }
}
