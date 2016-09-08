package model

import scala.collection.mutable

/**
  * Created by salim on 9/8/2016.
  */
trait Container[T <: BaseGameObject] {
  val contents = new mutable.HashMap[Int, T]

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
    contents.put(thing.sn, thing)
  }


}
