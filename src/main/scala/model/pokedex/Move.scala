package model.pokedex

/**
  * Created by salim on 12/09/2016.
  */
// id,identifier,generation_id,type_id,power,pp,accuracy,priority,target_id,damage_class_id,effect_id,effect_chance,contest_type_id,
// contest_effect_id,super_contest_effect_id

case class Move(id: Int, identifier: String, generation_id: Int, power: Int, pp: Int, accuracy: Int, priority: Int, target_id: Int, damage_class_id: Int, effect_id: Int, effect_chance: Int, contest_type_id: Int) {

}

object Move {
  def fromMap(row: Map[String, ConvertibleThing]): Move = ???
}

//object Move extends DexThing[Move] {
//  override def fromMap(row: Map[String, String]): Move = Move(
//    row("id").i,
//    row("identifier"),
//    row("species_id").i,
//    row("height").i,
//    row("weight").i,
//    row("base_experience").i,
//    row("order").i,
//    row("is_default").b
//  )
//}

