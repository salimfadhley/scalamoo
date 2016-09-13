package model.monsters
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
    val reader: CSVReader = CSVReader.open(source)
    reader.iteratorWithHeaders.foreach(addPokedexEntry(_))
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
    val is: InputStream = getClass.getResourceAsStream("/pokedex/pokedex/data/csv/pokemon.csv")
    val p = new Pokedex()
    p.addPokedexEntriesFromSource(Source.fromInputStream(is))
    p
  }

}
