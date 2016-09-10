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
    put(item, this.sn)
    item
  }

  def put(thing: T, container_id: Int) = {
    contents.put(thing.sn, thing)
  }

  def getById(sn: Int): Option[T] = {
    contents.get(sn)
  }


}
