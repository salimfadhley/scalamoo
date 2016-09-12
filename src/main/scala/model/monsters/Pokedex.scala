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

  def fromSource(source: Source): Unit = {
    val reader: CSVReader = CSVReader.open(source)
    reader.iteratorWithHeaders.foreach(add_entry(_))
  }

  def add_entry(row: Map[String, String]): Unit = {
    val pe: PokedexEntry = PokedexEntry.fromMap(row)
    dex.put(pe.id, pe)
  }

  def getById(i: Int): Option[PokedexEntry] = {
    dex.get(i)
  }
}

object Pokedex {
  def boot(): Pokedex = {
    val is: InputStream = getClass.getResourceAsStream("/pokedex/pokedex/data/csv/pokemon.csv")
    val p = new Pokedex()
    p.fromSource(Source.fromInputStream(is))
    p
  }

}
