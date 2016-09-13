package model.pokemon

/**
  * Created by salim on 12/09/2016.
  */
case class PokedexEntry(id: Int, name: String, species_id: Int, height: Int, weight: Int, base_experience: Int, order: Int, is_default: Boolean) {

}

object PokedexEntry extends DexThing[PokedexEntry] {
  override def fromMap(row: Map[String, String]): PokedexEntry = PokedexEntry(
    row("id").i,
    row("identifier"),
    row("species_id").i,
    row("height").i,
    row("weight").i,
    row("base_experience").i,
    row("order").i,
    row("is_default").b
  )
}

