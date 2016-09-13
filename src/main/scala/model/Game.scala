package model

import model.pokedex.Pokedex

/**
  * Created by salim on 12/09/2016.
  */
case class Game(world: World, pokedex: Pokedex)

object Game {
  def boot(): Game = {
    Game(World.factory, Pokedex.boot)
  }
}




