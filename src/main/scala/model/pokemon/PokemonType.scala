package model.pokemon

/**
  * Created by salim on 13/09/2016.
  */
case class PokemonType(id: Int, identifier: String, generation_id: Int, damage_class_id: Int) {

  def this(row: Map[String, String]) = this(
    row("id").i,
    row("identifier"),
    row("generation_id").i,
    row("damage_class_id").i
  )

}
