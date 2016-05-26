package relationships
import scala.collection.mutable.HashMap
/**
  * Created by sal on 24/05/16.
  */
class Container(_name: String, _registry: RelationshipRegistry) extends Thing(_name) {
  val contents = new HashMap[String,Thing]()
  val registry: RelationshipRegistry = _registry

  def add(thing: Thing): Unit = {
    contents.put(thing.name, thing)
  }
  def contains(t: Thing):Boolean = {
    contents.contains(t.name)
  }

  def relate(t1: Thing, t2: Thing, s: String): Any = {

  }

}
