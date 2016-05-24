package relationships

/**
  * Created by sal on 23/05/16.
  */

class RelationshipType(name:String, _inverse: =>RelationshipType, registry:RelationshipRegistry) {
  def newRelationship(a: Thing, b: Thing): Relationship = {
    new Relationship(a,b,this)
  }


  lazy val inverse:RelationshipType = _inverse

}
