package model

/**
  * Created by salim on 9/8/2016.
  */
case class World(sn: Int, snGenerator: () => Int) extends BaseGameObject with Container[Room] {
  override def contentsFactory(): Room = {
    Room(snGenerator(), snGenerator)
  }

  def newRoom: Room = {
    new Room(sn = snGenerator(), snGenerator)
  }

}

object World {
  def factory(): World = {
    val g = snGenratorFactory()
    World(g(), g)
  }

}
