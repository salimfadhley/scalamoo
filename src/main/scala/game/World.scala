package game

import relationships.{Container, RelationshipTypeRegistry}

/**
  * Created by sal on 28/05/16.
  */
class World(name: String) extends Container(name, new RelationshipTypeRegistry("Default")) {

  var defaultLocationId: Option[Int] = None


  def newLocation(name: String): Location = {
    val l = new Location(_name = name, _world = this)
    add(l).asInstanceOf[Location]

    defaultLocationId match {
      case None => setDefaulLocation(l)
      case Some(x: Int) =>
    }
    l
  }

  def setDefaulLocation(location: Location): Location = {
    defaultLocationId = Some(location.sn)
    location
  }

  def defaultLocation: Option[Location] = {
    defaultLocationId match {
      case None => None
      case Some(x: Int) => this.getById(x).asInstanceOf[Option[Location]]
    }
  }
}
