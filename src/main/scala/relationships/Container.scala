package relationships

import scala.collection.mutable
/**
  * Created by sal on 24/05/16.
  */
class Container(_name: String, _registry: RelationshipTypeRegistry) extends Thing(_name) {


  val relationships: mutable.Set[Relationship] = new mutable.HashSet[Relationship]()
  val registry: RelationshipTypeRegistry = _registry
  private val contents: mutable.Map[Int, Thing] = new mutable.HashMap[Int, Thing]()

  def getRelationships(t1: Thing, t2: Thing): Set[Relationship] = {
    relationships.filter((r: Relationship) => true).toSet
  }

  def contains(t: Thing):Boolean = {
    contents.contains(t.sn)
  }

  def relate(a: Thing, b: Thing, relationshipName: String): Relationship = {
    find(a, b, relationshipName) match {
      case Some(r: Relationship) => r
      case None => {
        val rr: Relationship = registry.getByName(relationshipName).newRelationship(a, b)
        add(a)
        add(b)
        relationships.add(rr)
        rr
      }
    }
  }

  def find(t1: Thing, t2: Thing, s: String): Option[Relationship] = {
    relationships.find(r => r.similar(t1, t2, s))
  }

  def add(thing: Thing): Unit = {
    contents.put(thing.sn, thing)
  }

  def hasRelationship(t1: Thing, t2: Thing, s: String): Boolean = {
    relationships.exists((r: Relationship) => r.similar(t1, t2, s))
  }

}
