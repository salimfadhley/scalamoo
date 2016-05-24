package relationships

/**
  * Created by sal on 23/05/16.
  */
case class RelationshipRegistry(name:String="xxx") {
  val relationshipsTypes = scala.collection.mutable.HashMap.empty[String,RelationshipType]

  def getByName(inverse_name: String):RelationshipType = {
    relationshipsTypes.get(inverse_name) match {
      case Some(x) => x
      case None => throw new UnknownRelationshipTypeException(s"Unknown relationship type $inverse_name")
    }
  }

  def createRelationshipPairs(a: String, b: String): RelationshipPair = {
    val aa:RelationshipType = new RelationshipType(a,b, this)
    val bb:RelationshipType = new RelationshipType(b,a, this)

    relationshipsTypes.put(a, aa)
    relationshipsTypes.put(b, bb)

    new RelationshipPair(aa, bb)
  }
}
