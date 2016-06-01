package game

import relationships.{Container, Relationship}

import scala.collection.mutable

/**
  * Created by sal on 28/05/16.
  */
class Location(_name: String, _world: World) extends Container(_name, _registry = _world.registry) {

  val world: World = _world
  val players:mutable.HashMap[Int,Player] = new mutable.HashMap[Int,Player]()

  def in(w: World): Boolean = w.contains(this)

  def exits: Set[Exit] = {
    _world.getRelationships(this).map(
      (r: Relationship) => new Exit(r.b.asInstanceOf[Location], r.relationshipType.inverse)
    ).toSet
  }

  def addPlayer(p: Player): Player = {
    players.put(p.sn, p)
    p.setLocation(this)
    p
  }

  def takePlayer(playerSn: Int): Player = {
    val p: Player = players.remove(playerSn) match {
      case Some(p:Player) => p
      case None => throw new NoSuchPlayer(s"No player has id $playerSn")
    }
    p.clearLocation
    p
  }

  def contains(p:Player):Boolean = {
    players.keySet.contains(p.sn)
  }

}