package model.pokedex
import java.io.InputStream

import com.github.tototoshi.csv._

import scala.collection.mutable
import scala.io.Source

/**
  * Created by salim on 12/09/2016.
  */
class Pokedex {
  val dex = mutable.HashMap[Int, PokedexEntry]()

  def addPokedexEntriesFromSource(source: Source): Unit = {
    CSVReader.open(source).iteratorWithHeaders.foreach(addPokedexEntry(_))
  }

  def addPokedexEntry(row: Map[String, String]): Unit = {
    val pe: PokedexEntry = PokedexEntry.fromMap(row)
    dex.put(pe.id, pe)
  }

  def getPokedexEntriesById(i: Int): Option[PokedexEntry] = {
    dex.get(i)
  }
}

object Pokedex {
  def boot(): Pokedex = {
    val p = new Pokedex()

    val pokemon: InputStream = getClass.getResourceAsStream("/pokedex/pokedex/data/csv/pokemon.csv")
    p.addPokedexEntriesFromSource(Source.fromInputStream(pokemon))

    p
  }

}


