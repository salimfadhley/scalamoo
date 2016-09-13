package model.pokemon

/**
  * Created by salim on 12/09/2016.
  */
case class PokedexEntry(id: Int, name: String, speciesId: Int, height: Int, weight: Int, baseExperience: Int, order: Int, isDefault: Boolean) {
}

object PokedexEntry {

  def fromMap(row: Map[String, String]) = {
    PokedexEntry(
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


}