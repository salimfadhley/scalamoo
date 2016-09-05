package game

import relationships.Relationship

/**
  * Created by salim on 31/05/2016.
  */
trait  Movable {
  var location: Option[Location] = None

  def setLocation(l: Location) = {
    location = Some(l)
  }

  def clearLocation(): Unit = {
    location = None
  }

  def getExits(): Option[Relationship] = {
    None
  }

  def moveDirection(direction:String): Option[Location] = {
    location

//    location match {
//      case Some(l:Location) => l.exits.toList.filter(_.direction.like(direction)) match {
//
//      }
//
//    }
  }

}
