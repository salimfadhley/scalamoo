package model.pokedex

/**
  * Created by salim on 12/09/2016.
  */
case class PokedexEntry(id: Int, name: String, species_id: Int, height: Int, weight: Int, base_experience: Int, order: Int, is_default: Boolean) extends DexClass {

  def getType(implicit pokedex: Pokedex): Type = {
    val pt = pokedex.getPokemonType(id).get
    pokedex.getType(pt.type_id).get
  }

  override def uid: Int = id

}

object PokedexEntry extends DexObject[PokedexEntry] {
  override def fromMap(row: Map[String, ConvertibleThing]): PokedexEntry = PokedexEntry(
    row("id").i,
    row("identifier").s,
    row("species_id").i,
    row("height").i,
    row("weight").i,
    row("base_experience").i,
    row("order").i,
    row("is_default").b
  )

}

