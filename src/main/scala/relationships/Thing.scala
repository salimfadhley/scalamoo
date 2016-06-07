package relationships

import game.Player

/**
  * Created by sal on 24/05/16.
  */
case class Thing(name: String, prototype: Prototype = null) extends Visible with Ownable {
  val sn: Int = Thing.counter.next()

  def look(intensity:Int) = {
    s"$article $name"
  }

  def article:String = {
    val vowels:Set[Char] = "aeiou".toSet

    (name.head, owner) match {
      case (c:Char, _) if c.isUpper => "the"
      case (_, Some(o)) => s"${o.name}'s"
      case (c:Char, _) if vowels.contains(c) => "an"
      case (_,_) => "a"
    }
  }
}

object Thing {
  val counter: Iterator[Int] = Iterator.from(0)
}
