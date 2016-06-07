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

    owner match {
      case Some(o:Player) => s"${o.name}'s"
      case _ => {
        name.head match {
          case c:Char if vowels.contains(c) => "an"
          case c:Char if c.isLower => "a"
          case _ => "the"
        }
      }
    }



  }
}

object Thing {
  val counter: Iterator[Int] = Iterator.from(0)
}
