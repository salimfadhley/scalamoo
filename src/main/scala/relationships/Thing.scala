package relationships

/**
  * Created by sal on 24/05/16.
  */
case class Thing(name: String, prototype: Prototype = null) {
  val sn: Int = Thing.counter.next()
}

object Thing {
  val counter: Iterator[Int] = Iterator.from(0)
}
