package model

/**
  * Created by salim on 9/11/2016.
  */
trait Address[T <: BaseGameObject] {

  def resolve(world: World): Option[T]

}
