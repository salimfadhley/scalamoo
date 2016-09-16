package model

import model.pokedex.Pokedex

/**
  * Created by salim on 12/09/2016.
  */
case class Game(world: World, pokedex: Pokedex, snGenerator: () => Int) {
  def spawnPlayer: Player = {
    Player(snGenerator())
  }

}






object Game {
  def boot(): Game = {
    val g = snGenratorFactory()
    Game(World.factory(g), Pokedex.boot, snGenratorFactory())
  }
}




