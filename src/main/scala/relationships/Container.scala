package relationships
import scala.collection.mutable.HashMap
/**
  * Created by sal on 24/05/16.
  */
class Container(_name:String) extends Thing(_name) {
  val contents = new HashMap[String,Thing]()

  def add(thing: Thing): Unit = {
    contents.put(thing.name, thing)
  }
  def contains(t: Thing):Boolean = {
    contents.contains(t.name)
  }
}
