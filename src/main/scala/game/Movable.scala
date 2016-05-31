package game

/**
  * Created by salim on 31/05/2016.
  */
trait Movable {
  var location:Option[Location] = None

  def setLocation(l: Location) = {
    location = Some(l)
  }
}
