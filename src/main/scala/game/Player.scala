package game

import relationships.{Observer, Thing}

/**
  * Created by sal on 30/05/16.
  */
class Player(_name: String) extends Thing(_name) with Movable with Observer {

  def createThing(name: String): Thing = {
    val t = new Thing(name)
    t.setOwner(this)
    t
  }

  def look(intesity:Int):String = {
  this.location match {
    case None => "You are in a formless void."
    case Some(l:Location) => (s"You are in ${l.observe}. " + l.observeContents.map(_.observe).mkString(" ")).trim
  }
  }

  def moveDirection(direction: String): Option[Location] = {
    location match {
      case None => throw new PlayerIsInLimbo("Meh!")
      case Some(l: Location) => {
        val e: Option[Exit] = l.findExit(direction)
        e match {
          case None => throw new NoWayOut(direction)
          case Some(ee: Exit) => {
            l.takePlayer(sn)
            location = Some(ee.to)
            ee.to.addPlayer(this)
          }
        }
      }
    }
    location
  }

}
