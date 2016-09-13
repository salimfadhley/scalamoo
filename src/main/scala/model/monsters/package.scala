package model

/**
  * Created by salim on 13/09/2016.
  */
case class ConvertibleThing(s: String) {
  def i: Int = s.toInt

  def b: Boolean = s.toInt > 0
}

package object monsters extends {
  implicit def stringToConvertible(s: String): ConvertibleThing = {
    ConvertibleThing(s)
  }
}






