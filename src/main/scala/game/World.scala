package game

import relationships.{Container, RelationshipTypeRegistry}

/**
  * Created by sal on 28/05/16.
  */
class World(name: String) extends Container(name, new RelationshipTypeRegistry("Default")) {

  def newLocation(name: String): Location = {
    val l = new Location(_name = name, _world = this)
    add(l).asInstanceOf[Location]
  }

}
