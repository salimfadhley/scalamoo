import java.io.InputStream

val stream: InputStream = getClass.getResourceAsStream("/pokedex/pokedex/data/csv/pokemon.csv")
val lines = scala.io.Source.fromInputStream(stream).getLines