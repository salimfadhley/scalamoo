package world

/**
  * Created by salim on 9/8/2016.
  */
case class Room(sn: Int, snGenerator: () => Int) extends BaseGameObject with Container[Thing] {

  override def contentsFactory(): Thing = {
    Thing(sn = snGenerator())
  }

}
