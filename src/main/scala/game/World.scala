package game


import relationships.{Container, RelationshipTypeRegistry, Thing}

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

  def takePlayer(playerSn: Int, locationSn: Int): Player = {
    getById(locationSn).asInstanceOf[Option[Location]] match {
      case Some(l: Location) => l.takePlayer(playerSn)
      case _ => throw new NoSuchLocation(s"No location has id ${locationSn}")
    }
  }

  def movePlayer(playerSn: Int, newLocationSn: Int): Player = {
    val l: Location = playersIdToLocations.get(playerSn) match {
      case Some(l: Location) => l
      case None => throw new RuntimeException("REPLACE ME!!!!")
    }
    getById(newLocationSn) match {
      case Some(l: Location) => addPlayer(l.takePlayer(playerSn))
    }
  }

  def addPlayer(player: Player): Player = {
    defaultLocation match {
      case None => throw new CannotAddPlayer("Default location has not been defined")
      case Some(l:Location) => l.addPlayer(player)
    }
  }

  def defaultLocation: Option[Location] = {
    defaultLocationId match {
      case None => None
      case Some(x: Int) => this.getById(x).asInstanceOf[Option[Location]]
    }
  }

  def playersIdToLocations: Map[Int, Location] = {
    // Map player IDs to their locations
    contents.valuesIterator
      .map((l: Thing) => l.asInstanceOf[Location].players.valuesIterator)
      .flatten
      .map((p: Player) => (p.sn, p.location match {
        case Some(l: Location) => l
        case _ => throw new RuntimeException("Found a player in a location with no reference back to the location!")
      }))
      .toMap
  }

  def players:Iterator[Player] = {
    contents.valuesIterator.map(_.asInstanceOf[Location].players.valuesIterator).flatten
  }

}
