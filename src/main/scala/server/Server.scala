import java.io._
import java.net._

import scala.io._

object Server extends App {
  val server = new ServerSocket(9999)
  while (true) {
    val s = server.accept()
    val in = new BufferedSource(s.getInputStream()).getLines()
    val out = new PrintStream(s.getOutputStream())

    out.println(in.next())
    out.flush()
    s.close()
  }
}

