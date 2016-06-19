package game

import relationships.Observable

/**
  * Created by sal on 15/06/16.
  */
case class Unrelated(items: List[Observable]) extends Observable {
  override def observe: String = {
    "You can see " + (items.map(_.observe).sorted match {
      case o:List[String] if o.size > 1 => o.init.mkString(", ") + " and " + o.last
      case o:List[String] if o.size == 1 => o.head
      case Nil => "Nothing"
    }) + "."

  }
}
