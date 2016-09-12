package model.monsters

/**
  * Created by salim on 12/09/2016.
  */
case class PokedexEntry(id: Int, name: String, speciesId: Int, height: Int, weight: Int, baseExperience: Int, order: Int, isDefault: Boolean) {

  // base_experience,order,is_default

}

object PokedexEntry {

  def fromMap(row: Map[String, String]) = {
    // id,identifier,species_id,height,weight,base_experience,order,is_default
    val id = row("id").toInt
    val name = row("identifier")
    val speciesId = row("species_id").toInt
    val height = row("height").toInt
    val weight = row("weight").toInt
    val baseExperience = row("base_experience").toInt
    val order = row("order").toInt
    val isDefault = row("is_default").toInt > 0
    PokedexEntry(id, name, speciesId, height, weight, baseExperience, order, isDefault)
  }


}