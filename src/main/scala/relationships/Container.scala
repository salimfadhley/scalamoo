package relationships


class CannotContain(message: String) extends RuntimeException(message)

/**
  * Created by sal on 24/05/16.
  */
class Container(_name: String, _registry: RelationshipTypeRegistry) extends Thing(_name) with Containerish {
  val registry: RelationshipTypeRegistry = _registry

  override def observeContents:Iterator[Observable] = {
    relationships.iterator
  }
}
