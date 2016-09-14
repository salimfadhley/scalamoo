package model

/**
  * Created by salim on 13/09/2016.
  */
case class ConvertibleThing(s: String) {
  def i: Int = {
    try {
      s.toInt
    } catch {
      case e: NumberFormatException => -1
    }
  }
  def b: Boolean = s.toInt > 0
}

package object pokedex extends {
  implicit def stringToConvertible(s: String): ConvertibleThing = {
    ConvertibleThing(s)
  }
}






