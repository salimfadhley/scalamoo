package game

import relationships.Container

/**
  * Created by sal on 28/05/16.
  */
class Location(_name: String, _world: World) extends Container(_name, _registry = _world.registry) {

  val world: World = _world

  def in(w: World): Boolean = w.contains(this)

  def exits: List[Exit] = {
    List[Exit]()
  }


}
