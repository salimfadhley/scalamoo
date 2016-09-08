package world

/**
  * Created by salim on 9/8/2016.
  */
case class World(sn: Int, snGenerator: () => Int) extends BaseGameObject with Container[Room] {
  override def contentsFactory(): Room = {
    Room(snGenerator(), snGenerator)
  }
}

object World {

}
