package relationships

/**
  * Created by sal on 24/05/16.
  */
case class Relationship(a:Thing, b:Thing, relationshipType:RelationshipType) {
  def inverse = {
    Relationship(b,a, relationshipType.inverse)
  }
}
