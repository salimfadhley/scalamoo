package interact

/**
  * Created by sal on 21/06/17.
  */
class Login(ls: LoginService) extends Interaction {

  override def interact(io: InputOutput): Unit = {
    io.out("Welcome to the game!")

    try {
      while (!ls.isLoggedIn) {
        io.out("Please enter your player name:")
        io.in.take(1).toList match {
          case l :: Nil => {
            ls.loginAs(l)
            throw new LoginComplete
          }
          case _ =>
        }

      }
    } catch {
      case _:LoginComplete => {
        io.out(s"Welcome to the game!")
      }
    }
  }
}
