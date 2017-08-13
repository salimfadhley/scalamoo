package model

/**
  * Created by salim on 9/10/2016.
  */
trait Containable extends BaseGameObject {

  var containerId: Option[Int] = None

  def clearContainer(): Unit = {
    containerId = None
  }

}
