package model

import scala.collection.mutable

/**
  * Created by salim on 9/8/2016.
  */
trait Container[T <: Containable] extends BaseGameObject {
  private val contents = new mutable.HashMap[Int, T]

  def snGenerator: () => Int

  def contentsFactory(): T

  def get(sn: Int): Option[T] = {
    contents.get(sn)
  }

  def spawn(): T = {
    val item = contentsFactory()
    put(item)
    item
  }

  def put(thing: T) = {
    thing.containerId match {
      case None => {
        thing.containerId = Some(sn)
        contents.put(thing.sn, thing)
      }
      case Some(id) if id != sn => throw new AlreadyInAContainer(s"Already in container ${id}")
      case _ =>
    }
  }

  def remove(t: Thing): Option[T] = remove(t.sn)

  def remove(sn: Int): Option[T] = {
    val item = contents.remove(sn)

    item match {
      case Some(i) => {
        i.clearContainer()
        item
      }
      case None =>
    }

    item
  }

  def getById(sn: Int): Option[T] = {
    contents.get(sn)
  }


}
