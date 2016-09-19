package model.pokedex

/**
  * Created by salim on 14/09/2016.
  */
case class Type(id: Int, identifier: String, generation_id: Int, damage_class_id: Int) {
  // id,identifier,generation_id,damage_class_id
}

object Type extends DexThing[Type] {
  override def fromMap(row: Map[String, ConvertibleThing]): Type = Type(
    row("id").i,
    row("identifier")._s,
    row("generation_id").i,
    row("damage_class_id").i
  )
}
