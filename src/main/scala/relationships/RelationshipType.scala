package relationships

/**
  * Created by sal on 23/05/16.
  */

case class RelationshipType(name:String, inverse_name:String, registry:RelationshipRegistry) {

  def newRelationship(a: Thing, b: Thing): Relationship = {
    new Relationship(a,b,this)
  }

  def inverse = registry.getByName(inverse_name)

}
