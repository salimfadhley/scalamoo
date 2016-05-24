package relationships

/**
  * Created by sal on 24/05/16.
  */
class Relationship(_a:Thing, _b:Thing, _relationshipType:RelationshipType, _inverse: => Relationship) {
  lazy val inverse:Relationship = _inverse
  val a:Thing = _a
  val b:Thing = _b
  val relationshipType = _relationshipType
}
