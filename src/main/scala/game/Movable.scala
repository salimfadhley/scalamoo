package game

/**
  * Created by salim on 31/05/2016.
  */
trait Movable {
  var location: Option[Location] = None

  def sn: Int

  def setLocation(l: Location) = {
    location = Some(l)
  }

  def clearLocation(): Unit = {
    location = None
  }

  def moveDirection(direction: String): Option[Location]
}
