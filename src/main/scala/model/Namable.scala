package model

/**
  * Created by salim on 9/9/2016.
  */
trait Namable[T] {
  var name: Option[String] = None

  def named(n: String): T = {
    setName(n)
    this.asInstanceOf[T]
  }

  def setName(n: String) = {
    name = Some(n)
  }

}
