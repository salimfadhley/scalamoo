package model.battle

/**
  * Created by salim on 17/09/2016.
  */
case class BatleRound(p1Strategy: BattleStrategy, p2Strategy: BattleStrategy) extends BattleRoundInterface {
  override def round: BattleRoundOutcome = {
    ???
  }
}
