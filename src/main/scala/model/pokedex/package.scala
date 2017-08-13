package model

/**
  * Created by salim on 13/09/2016.
  */

package object pokedex extends {
  implicit def stringToConvertible(s: String): ConvertibleThing = {
    ConvertibleThing(s)
  }

  implicit def stringMapToConvertibleMap(inp: Map[String, String]): Map[String, ConvertibleThing] = {
    inp.map((x: (String, String)) => (x._1, ConvertibleThing(x._2)))
  }
}






