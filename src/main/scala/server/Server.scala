import java.io._
import java.net._

import repl.{Repl, Rot13}

import scala.io._

object Server extends App {
  val server_port: Int = 9999


  override def main(args: Array[String]): Unit = {

    println(s"Opening a server on ${server_port}")
    val server = new ServerSocket(server_port)



    println(s"Waiting on ${server.getLocalPort}.")

    while (true) {
      val s = server.accept()
      val in = new BufferedSource(s.getInputStream)
      val out = new PrintStream(s.getOutputStream())
      Repl.loop(in, out, Rot13.translate)
      s.close()
    }
  }
}

