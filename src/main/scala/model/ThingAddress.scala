package model

case class ThingAddress(roomSn: Int, thingSn: Int) extends Address[Thing] {
  override def resolve(world: World): Option[Thing] = {
    world.getById(roomSn) match {
      case None => None
      case Some(r: Room) => r.getById(thingSn)
    }
  }
}