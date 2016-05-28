package game

import relationships.RelationshipTypeRegistry

/**
  * Created by sal on 28/05/16.
  */
class World(name: String) {
  val registy = new RelationshipTypeRegistry(name)

  def newLocation(name: String): Location = {
    new Location(name, registy, this)
  }

}
