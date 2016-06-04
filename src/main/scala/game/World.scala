package game


import relationships.{Container, RelationshipTypeRegistry, Thing}

/**
  * Created by sal on 28/05/16.
  */
class World(name: String) extends Container(name, new RelationshipTypeRegistry("Default")) {


  var defaultLocationId: Option[Int] = None

  def newLocation(name: String): Location = {
    val l = new Location(_name = name, _world = this)
    add(l)

    defaultLocationId match {
      case None => setDefaulLocation(l)
      case Some(x: Int) =>
    }
    l
  }

  def add(l: Location): Location = {
    super.add(l).asInstanceOf[Location]
  }

  def setDefaulLocation(location: Location): Location = {
    defaultLocationId = Some(location.sn)
    location
  }

  def takePlayer(playerSn: Int, locationSn: Int): Player = {
    getById(locationSn).asInstanceOf[Option[Location]] match {
      case Some(l: Location) => l.takePlayer(playerSn)
      case _ => throw new NoSuchLocation(s"No location has id $locationSn")
    }
  }

  def movePlayer(player: Player, direction: String): Unit = {
    player.location match {
      case None => throw new NoSuchLocation(s"Player does not yet have a location")
      case Some(l: Location) =>
        val relatedLocations: List[Location] = getRelated(l, direction).toList
        relatedLocations match {
          case nl :: rest => movePlayer(player, nl)
          case Nil => throw new NoSuchDirection(direction)
        }
    }
  }

  def movePlayer(player: Player, newLocation: Location): Player = {
    player.location match {
      case Some(l: Location) => newLocation.addPlayer(l.takePlayer(player.sn))
      case _ => newLocation.addPlayer(player)
    }
  }

  def getRelated(l: Location, rn: String): Iterator[Location] = {
    super.getRelated(l.asInstanceOf[Thing], rn).asInstanceOf[Iterator[Location]]
  }

  def addPlayer(player: Player): Player = {
    defaultLocation match {
      case None => throw new CannotAddPlayer("Default location has not been defined")
      case Some(l: Location) => l.addPlayer(player)
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

  def players: Iterator[Player] = {
    contents.valuesIterator.map(_.asInstanceOf[Location].players.valuesIterator).flatten
  }
}

object World {
  def bootstrap(name: String): World = {
    val w = new World(name)

    w.registry.createRelationshipPairs("North", "South")
    w.registry.createRelationshipPairs("East", "West")

    w
  }
}
