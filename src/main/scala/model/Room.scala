package model

/**
  * Created by salim on 9/8/2016.
  */
case class Room(sn: Int, snGenerator: () => Int, container: World) extends Container[Thing] with Namable[Room] with Containable {

  override def contentsFactory(): Thing = {
    Thing(sn = snGenerator(), container = this)
  }

  def newThing: Thing = {
    spawn()
  }


}
