package model.pokedex
import com.github.tototoshi.csv._

import scala.collection.mutable
import scala.io.Source

/**
  * Created by salim on 12/09/2016.
  */
class Pokedex {
  val pokemon = mutable.HashMap[Int, PokedexEntry]()
  val pokemonTypes = mutable.HashMap[Int, PokemonType]()
  val types = mutable.HashMap[Int, Type]()

  def getPokemonType(id: Int): Option[PokemonType] = {
    pokemonTypes.get(id)
  }

  def getPokedexEntriesById(i: Int): Option[PokedexEntry] = {
    pokemon.get(i)
  }

  def getType(i: Int): Option[Type] = {
    types.get(i)
  }

  def addPokedexEntry(row: Map[String, ConvertibleThing]): Unit = {
    val pe: PokedexEntry = PokedexEntry.fromMap(row)
    pokemon.put(pe.id, pe)
  }

  def addPokemonType(row: Map[String, ConvertibleThing]): Unit = {
    val pt: PokemonType = PokemonType.fromMap(row)
    pokemonTypes.put(pt.pokemon_id, pt)
  }

  def addType(row: Map[String, ConvertibleThing]): Unit = {
    val pt: Type = Type.fromMap(row)
    types.put(pt.id, pt)
  }



}

object Pokedex {


  def boot: Pokedex = {
    val p = new Pokedex()
    openStreamAndLoad("pokemon", p.addPokedexEntry)
    openStreamAndLoad("pokemon_types", p.addPokemonType)
    openStreamAndLoad("types", p.addType)

    p
  }

  def openStreamAndLoad(s: String, addEntry: (Map[String, ConvertibleThing]) => Unit) = {
    val path: String = s"/pokedex/pokedex/data/csv/$s.csv"
    val data: Source = Source.fromInputStream(getClass.getResourceAsStream(path))
    loadItemsFromSource(addEntry, data)
  }

  def loadItemsFromSource(addEntry: (Map[String, ConvertibleThing]) => Unit, data: Source): Unit = {
    CSVReader.open(data).iteratorWithHeaders.map(stringMapToConvertibleMap).foreach(addEntry)
  }


  //
  //    //    val pokemon: InputStream = getClass.getResourceAsStream("/pokedex/pokedex/data/csv/pokemon.csv")
  //    //    p.addPokedexEntriesFromSource(Source.fromInputStream(pokemon))
  //
  ////    openStreamAndLoad[PokedexEntry]("pokemon", p.pokemon)
  //
  //  }

}


