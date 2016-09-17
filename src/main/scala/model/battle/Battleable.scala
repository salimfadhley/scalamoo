package model.battle

/**
  * Created by salim on 12/09/2016.
  */
trait Battleable {

  var maxHitPoints: Int
  var damagePoints: Int = 0

  def doDamage(points: Int) = {
    damagePoints += points
  }

  def canBattle = !(battleStatus == Status.Unconcious)

  def battleStatus: Status.Value = {
    hitPoints match {
      case 0 => Status.Unconcious
      case _ => Status.OK
    }
  }

  def hitPoints = {
    math.max(maxHitPoints - damagePoints, 0)
  }





}
