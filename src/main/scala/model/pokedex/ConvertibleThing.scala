package model.pokedex

/**
  * Created by salim on 19/09/2016.
  */
case class ConvertibleThing(_s: String) {

  def i: Int = {
    try {
      _s.toInt
    } catch {
      case e: NumberFormatException => -1
    }
  }

  implicit def b: Boolean = _s.toInt > 0

  implicit def s: String = _s
}

object ConvertibleThing {

  def unapply(s: String): ConvertibleThing = {
    ConvertibleThing(s)
  }

}