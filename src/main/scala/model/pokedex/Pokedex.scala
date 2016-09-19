package model.pokedex
import com.github.tototoshi.csv._

import scala.io.Source

/**
  * Created by salim on 12/09/2016.
  */
class Pokedex {
  lazy val pokemon = streamToMap[PokedexEntry]("pokemon", PokedexEntry.fromMap _)
  lazy val pokemonTypes = streamToMap[PokemonType]("pokemon_types", PokemonType.fromMap _)
  lazy val types = streamToMap[Type]("types", Type.fromMap _)
  lazy val moves = streamToMap[Move]("moves", Move.fromMap _)
  lazy val pokemonMoves = streamToMap[PokemonMove]("pokemon_moves", PokemonMove.fromMap _)


  def streamToMap[T <: DexClass](source: String, fromMap: (Map[String, ConvertibleThing]) => T) = {
    val path: String = s"/pokedex/pokedex/data/csv/$source.csv"
    val data: Source = Source.fromInputStream(getClass.getResourceAsStream(path))
    CSVReader.open(data).iteratorWithHeaders.map(stringMapToConvertibleMap).map(fromMap).map((t: T) => (t.uid, t)).toMap
  }

  def getPokemonType(id: Int): Option[PokemonType] = {
    pokemonTypes.get(id)
  }

  def getPokedexEntriesById(i: Int): Option[PokedexEntry] = {
    pokemon.get(i)
  }

  def getType(i: Int): Option[Type] = {
    types.get(i)
  }
}

object Pokedex {


  def boot: Pokedex = {
    new Pokedex()
  }


  def openStreamAndLoad(s: String, addEntry: (Map[String, ConvertibleThing]) => Unit) = {
    val path: String = s"/pokedex/pokedex/data/csv/$s.csv"
    val data: Source = Source.fromInputStream(getClass.getResourceAsStream(path))
    loadItemsFromSource(addEntry, data)
  }

  def loadItemsFromSource(addEntry: (Map[String, ConvertibleThing]) => Unit, data: Source): Unit = {
    CSVReader.open(data).iteratorWithHeaders.map(stringMapToConvertibleMap).foreach(addEntry)
  }



}


