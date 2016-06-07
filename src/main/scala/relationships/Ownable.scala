package relationships

import game.Player

/**
  * Created by salim on 07/06/2016.
  */
trait Ownable {
  var owner:Option[Player] = None

  def setOwner(p:Player):Unit = {
    owner = Some(p)
  }

}
