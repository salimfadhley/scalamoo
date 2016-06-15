package game

import relationships.Observable

/**
  * Created by sal on 15/06/16.
  */
case class Unrelated(items: List[Observable]) extends Observable {
  override def observe: String = "xxx"
}
