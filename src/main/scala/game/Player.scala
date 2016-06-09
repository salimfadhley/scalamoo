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
    case Some(l:Location) => (s"You are in ${l.observe(0)}. " + l.observeContents().map(_.observe(intesity+1)).mkString(" ")).trim
  }
  }

}
