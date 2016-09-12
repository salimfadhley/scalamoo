object CSVDemo extends App {

  def main(): Unit = {
    val bufferedSource = io.Source.fromFile("pokedex/pokedex/data/csv/pokemon.csv")
    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }
    bufferedSource.close
  }
}

CSVDemo.main()