package relationships

/**
  * Created by sal on 24/05/16.
  */
class Relationship(_a: Thing, _b: Thing, _relationshipType: RelationshipType, _inverse: => Relationship, _canonical: Boolean) {
  lazy val inverse:Relationship = _inverse
  val a:Thing = _a
  val b:Thing = _b
  val relationshipType = _relationshipType
  val canonical: Boolean = _canonical
  val sn: Int = Relationship.counter.next
}

object Relationship {
  val counter: Iterator[Int] = Iterator.from(0)
}
