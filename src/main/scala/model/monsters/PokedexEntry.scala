package model.monsters

/**
  * Created by salim on 12/09/2016.
  */
case class PokedexEntry(id: Int, name: String) {

  def this(row: Map[String, String]) = {
    this(25, "pikachu")
  }


}