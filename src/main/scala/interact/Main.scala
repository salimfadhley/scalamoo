package interact

import scala.io.Source


/**
  * Created by salim on 6/19/2017.
  */
object Main extends App {

  def fnInteract(s:String):String = s"Hello $s\n"
  val ls = new LoginService()

  val login = new Login(ls)
  val gl = new GameLoop(fnInteract)

  val io = InputOutput(Source.fromInputStream(System.in).getLines(), (s:String) => System.out.print(s"${s}\n"))

  val inputIterator: Iterator[String] = Source.fromInputStream(System.in).getLines()

  login.interact(io)
  gl.interact(io)

}
