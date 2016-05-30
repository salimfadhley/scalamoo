package game

import relationships.{Container, Relationship}

/**
  * Created by sal on 28/05/16.
  */
class Location(_name: String, _world: World) extends Container(_name, _registry = _world.registry) {
  val world: World = _world

  def in(w: World): Boolean = w.contains(this)

  def exits: Set[Exit] = {
    _world.getRelationships(this).map(
      (r: Relationship) => new Exit(r.b.asInstanceOf[Location], r.relationshipType.inverse)
    ).toSet
  }


}
