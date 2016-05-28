package game

import relationships.{Container, RelationshipTypeRegistry}

/**
  * Created by sal on 28/05/16.
  */
class Location(_name: String, _registry: RelationshipTypeRegistry, _world: World) extends Container(_name, _registry) {
  val world: World = _world

}
