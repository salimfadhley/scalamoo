package interact

/**
  * Created by sal on 21/06/17.
  */
class LoginService() {

  var user:Option[String] = None

  def loginAs(l: String):Unit = {
    user = Some(l)
  }

  def isLoggedIn:Boolean = {
    user match {
      case None => false
      case _ => true
    }
  }

}
