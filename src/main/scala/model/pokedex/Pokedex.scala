package model.pokedex
import com.github.tototoshi.csv._

import scala.collection.mutable
import scala.io.Source

/**
  * Created by salim on 12/09/2016.
  */
class Pokedex {
  lazy val pokemon = mutable.HashMap[Int, PokedexEntry]()
  lazy val pokemonTypes = mutable.HashMap[Int, PokemonType]()
  lazy val types = mutable.HashMap[Int, Type]()
  lazy val moves = mutable.HashMap[Int, Move]()
  lazy val pokemonMoves = mutable.HashMap[Int, PokemonMove]()

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

  def addMove(row: Map[String, ConvertibleThing]): Unit = {
    val mv: Move = Move.fromMap(row)
    moves.put(mv.id, mv)
  }

  def addPokemonMove(row: Map[String, ConvertibleThing]): Unit = {
    val mv: PokemonMove = PokemonMove.fromMap(row)
    pokemonMoves.put(mv.pokemon_id, mv)
  }




}

object Pokedex {


  def boot: Pokedex = {
    val p = new Pokedex()
    openStreamAndLoad("pokemon", p.addPokedexEntry)
    openStreamAndLoad("pokemon_types", p.addPokemonType)
    openStreamAndLoad("types", p.addType)
    openStreamAndLoad("moves", p.addMove)
    openStreamAndLoad("pokemon_moves", p.addPokemonMove)

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


