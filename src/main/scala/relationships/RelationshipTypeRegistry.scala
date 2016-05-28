package relationships

/**
  * Created by sal on 23/05/16.
  */

case class RedefinitionOfRelationshipException(message: String) extends RuntimeException(message)

case class RelationshipTypeRegistry(name: String = "xxx") {

  val relationshipsTypes = scala.collection.mutable.HashMap.empty[String,RelationshipType]

  def getByName(name: String): RelationshipType = {
    relationshipsTypes.get(name) match {
      case Some(x) => x
      case None => throw new UnknownRelationshipTypeException(s"Unknown relationship type $name")
    }
  }

  def createRelationshipPairs(a: String, b: String): RelationshipTypePair = {

    (relationshipsTypes.get(a), relationshipsTypes.get(b)) match {
      case (Some(aa), Some(bb)) => return RelationshipTypePair(aa, bb)
      case (Some(aa), None) => throw new RedefinitionOfRelationshipException(a)
      case (None, Some(bb)) => throw new RedefinitionOfRelationshipException(b)
      case (None, None) => {
        lazy val aa: RelationshipType = new RelationshipType(a, new RelationshipType(b, aa, this), this)
        val bb: RelationshipType = aa.inverse
        relationshipsTypes.put(a, aa)
        relationshipsTypes.put(b, bb)
        new RelationshipTypePair(aa, bb)
      }
    }
  }
}
