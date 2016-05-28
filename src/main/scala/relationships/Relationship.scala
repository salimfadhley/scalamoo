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

  def similar(r: Relationship): Boolean = {
    similar(r.a, r.b, r.relationshipType.name)
  }

  def similar(t1: Thing, t2: Thing, s: String): Boolean = {
    (t1, t2, s) match {
      case (a, b, relationshipType.name) => true
      case (b, a, relationshipType.inverse.name) => true
      case _ => false
    }
  }


}

object Relationship {
  val counter: Iterator[Int] = Iterator.from(0)
}
