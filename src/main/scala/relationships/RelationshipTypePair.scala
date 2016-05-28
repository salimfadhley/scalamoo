package relationships

/**
  * Created by sal on 23/05/16.
  */


case class RelationshipTypePair(a: RelationshipType, b: RelationshipType) {

}

object RelationshipTypePair {
  implicit def asTuple(x: RelationshipTypePair): (RelationshipType, RelationshipType) = (x.a, x.b)
}