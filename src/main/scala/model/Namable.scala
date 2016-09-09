package model

/**
  * Created by salim on 9/9/2016.
  */
trait Namable {
  var name: Option[String] = None

  def setName(n: String) = {
    name = Some(n)
  }

}
