package model.pokedex

/**
  * Created by salim on 14/09/2016.
  */
case class PokemonType(pokemon_id: Int, type_id: Int, slot: Int) extends DexClass {
  def uid = pokemon_id
}

// pokemon_id,type_id,slot
object PokemonType extends DexObject[PokemonType] {
  override def fromMap(row: Map[String, ConvertibleThing]): PokemonType = {
    PokemonType(
      row("pokemon_id").i,
      row("type_id").i,
      row("slot").i
    )

  }
}
