package interact

import java.io.PrintStream
import java.net.ServerSocket

import scala.io.{BufferedSource, Source}

/**
  * Created by sal on 09/07/17.
  */
object SocketServer extends App {

  val server = new ServerSocket(9999)
  while (true) {
    val s = server.accept()
    val in = new BufferedSource(s.getInputStream).getLines()
    val out = new PrintStream(s.getOutputStream)

    def fnInteract(s:String):String = s"Hello $s\n"
    val ls = new LoginService()

    val login = new Login(ls)
    val gl = new GameLoop(fnInteract)

    val io = InputOutput(in, (s:String) => out.print(s"${s}\n"))

    login.interact(io)
    gl.interact(io)
  }

}
