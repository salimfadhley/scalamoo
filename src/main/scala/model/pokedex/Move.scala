package model.pokedex

/**
  * Created by salim on 12/09/2016.
  */

case class Move(id: Int, identifier: String, generation_id: Int, power: Int, pp: Int, accuracy: Int, priority: Int, target_id: Int, damage_class_id: Int, effect_id: Int, effect_chance: Int, contest_type_id: Int) {
}

object Move extends DexThing[Move] {
  override def fromMap(row: Map[String, ConvertibleThing]): Move = Move(
    row("id").i,
    row("identifier").s,
    row("generation_id").i,
    row("power").i,
    row("pp").i,
    row("accuracy").i,
    row("priority").i,
    row("target_id").i,
    row("damage_class_id").i,
    row("effect_id").i,
    row("effect_chance").i,
    row("effect_id").i
  )
}

