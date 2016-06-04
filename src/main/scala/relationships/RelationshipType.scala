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

}
