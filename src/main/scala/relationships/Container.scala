package relationships


class CannotContain(message: String) extends RuntimeException(message)

import scala.collection.mutable
/**
  * Created by sal on 24/05/16.
  */
class Container(_name: String, _registry: RelationshipTypeRegistry) extends Thing(_name) {



  val relationships: mutable.Set[Relationship] = new mutable.HashSet[Relationship]()
  val registry: RelationshipTypeRegistry = _registry
  protected val contents: mutable.Map[Int, Thing] = new mutable.HashMap[Int, Thing]()

  def getRelationships(t1: Thing, t2: Thing): Set[Relationship] = {
    relationships.filter(_.relatesTo(t1)).filter(_.relatesTo(t2)).toSet
  }

  def getRelationships(t: Thing):Iterator[Relationship] = {
    relationships.filter(_.relatesTo(t)).map(_.fromPerspective(t)).iterator
  }

  def getRelated(t: Thing, rn: String): Iterator[Thing] = {
    getRelationships(t).toList.filter(_.relationshipType.inverse.name==rn).map(_.b).iterator
  }

  def getById(x: Int): Option[Thing] = {
    contents.get(x)
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

  def add[T <: Thing](thing: T): Thing = {
    if (canContain(thing)) {
      contents.put(thing.sn, thing)
    }
    thing
  }

  def canContain(thing: Thing): Boolean = {
    true
  }

  def hasRelationship(t1: Thing, t2: Thing, s: String): Boolean = {
    relationships.exists((r: Relationship) => r.similar(t1, t2, s))
  }




}
