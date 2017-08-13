package model.battle

/**
  * Created by salim on 17/09/2016.
  */
trait BattleRoundInterface {

  val p1Strategy: BattleStrategy
  val p2Strategy: BattleStrategy

  def round: BattleRoundOutcome

}
