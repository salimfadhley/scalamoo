package model.pokedex

trait DexClass {
  def uid: Int
}

trait DexObject[T <: DexClass] {
  def fromMap(row: Map[String, ConvertibleThing]): T
}
