package model.battle

/**
  * Created by salim on 12/09/2016.
  */
trait Battleable {
  var battleStatus = Status.OK
  var maxHitPoints: Int
  var damage: Int = 0


}
