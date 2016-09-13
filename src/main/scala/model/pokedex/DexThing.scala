package model.pokedex

/**
  * Created by salim on 13/09/2016.
  */
trait DexThing[T] {

  def fromMap(row: Map[String, String]): T

}
