package game

import relationships.Thing

/**
  * Created by sal on 30/05/16.
  */
class Player(_name: String) extends Thing(_name) with Movable {
  var location:Option[Location] = None

  def setLocation(l: Location) = {
    location = Some(l)
  }

}
