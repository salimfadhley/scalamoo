package relationships

import scala.collection.mutable
/**
  * Created by sal on 24/05/16.
  */
class Container(_name: String, _registry: RelationshipRegistry) extends Thing(_name) {
  val contents: mutable.Map[String, Thing] = new mutable.HashMap[String, Thing]()
  val relationships: mutable.Set[Relationship] = new mutable.HashSet[Relationship]()

  val registry: RelationshipRegistry = _registry

  def getRelationships(t1: Thing, t2: Thing): Set[Relationship] = {
    relationships.filter((r: Relationship) => true).toSet
  }

  def contains(t: Thing):Boolean = {
    contents.contains(t.name)
  }

  def relate(a: Thing, b: Thing, relationshipName: String): Relationship = {
    add(a)
    add(b)
    val rr: Relationship = registry.getByName(relationshipName).newRelationship(a, b)
    relationships.add(rr)
    rr
  }

  def add(thing: Thing): Unit = {
    contents.put(thing.name, thing)
  }

}
