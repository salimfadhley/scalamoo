package relationships

/**
  * Created by sal on 24/05/16.
  */
class Relationship(_a: Thing, _b: Thing, _relationshipType: RelationshipType, _inverse: => Relationship, _canonical: Boolean) {

  lazy val inverse: Relationship = _inverse
  val a: Thing = _a
  val b: Thing = _b
  val relationshipType = _relationshipType
  val canonical: Boolean = _canonical
  val sn: Int = Relationship.counter.next

  def similar(r: Relationship): Boolean = {
    similar(r.a, r.b, r.relationshipType.name)
  }

  def similar(t1: Thing, t2: Thing, s: String): Boolean = {

    val relationshipName = relationshipType.name
    val inverseRelationshipNae = relationshipType.inverse.name

    (t1, t2, s) match {
      case (`a`, `b`, `relationshipName`) => true
      case (`b`, `a`, `inverseRelationshipNae`) => true
      case _ => false
    }
  }

  def fromPerspective(t: Thing): Relationship = {
    t match {
      case this.a => this
      case this.b => this.inverse
      case _ => throw new RuntimeException(s"$this does not relate $t")
    }

  }

  def relatesTo(t: Thing): Boolean = {
    t match {
      case this.a => true
      case this.b => true
      case _ => false
    }
  }


}

object Relationship {
  val counter: Iterator[Int] = Iterator.from(0)
}
