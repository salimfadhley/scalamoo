package model

import model.battle.Status
import model.pokedex.Pokedex
import org.scalatest.FlatSpec

/**
  * Created by salim on 16/09/2016.
  */
class PokemonSpec extends FlatSpec {
  "Pokemon" should "be creatable by id" in {
    val pokedex: Pokedex = Pokedex.boot
    val p: Pokemon = Pokemon.spawn(pokedex, 25).named("Foofoo")
    assert(p.name.get == "Foofoo")
    assert(p.pokedexEntry.name == "pikachu")
  }

  "it" can "be knocked out" in {
    val pokedex: Pokedex = Pokedex.boot
    val p: Pokemon = Pokemon.spawn(pokedex, 25)
    assert(p.hitPoints == p.maxHitPoints)
    p.doDamage(p.maxHitPoints)
    assert(p.hitPoints == 0)
    assert(p.battleStatus == Status.Unconcious)
  }

  "it" can "never go below zero hit points" in {
    val pokedex: Pokedex = Pokedex.boot
    val p: Pokemon = Pokemon.spawn(pokedex, 25)
    assert(p.hitPoints == p.maxHitPoints)
    p.doDamage(p.maxHitPoints + 1)
    assert(p.hitPoints == 0)
    assert(p.battleStatus == Status.Unconcious)
  }


}
