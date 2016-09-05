package relationships

/**
  * Created by sal on 23/05/16.
  */

class RelationshipType(_name: String, _inverse: => RelationshipType, _registry: RelationshipTypeRegistry) {


  lazy val inverse: RelationshipType = _inverse
  val name: String = _name
  val registry: RelationshipTypeRegistry = _registry

  def newRelationship(a: Thing, b: Thing): Relationship = {
    lazy val rr: Relationship = new Relationship(a, b, this, new Relationship(b, a, this.inverse, rr, false), true)
    rr
  }

  def matchString(s: String):Boolean = {
    s.toLowerCase match {
      case ss if ss.isEmpty => false
      case ss if (name.toLowerCase == ss) => true
      case ss if name.toLowerCase.startsWith(ss) => true
      case _ => false
    }

  }



}
