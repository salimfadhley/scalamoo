package model.pokedex

/**
  * Created by salim on 13/09/2016.
  */

trait DexClass {
  def uid: Int
}

trait DexObject[T <: DexClass] {
  def fromMap(row: Map[String, ConvertibleThing]): T

}
