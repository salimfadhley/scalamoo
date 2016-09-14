package model.pokedex

/**
  * Created by salim on 14/09/2016.
  */
case class PokemonType(pokemon_id: Int, type_id: Int, slot: Int) {
}

// pokemon_id,type_id,slot
object PokemonType extends DexThing[PokemonType] {
  override def fromMap(row: Map[String, String]): PokemonType = {
    PokemonType(
      row("pokemon_id").i,
      row("type_id").i,
      row("slot").i
    )

  }
}
