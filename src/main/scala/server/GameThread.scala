package server

import java.io.PrintStream
import java.net.Socket

import repl.{Repl, Rot13}

import scala.io.BufferedSource

class GameThread(s: Socket) extends Runnable {

  implicit def stringToBytes(in: String): Array[Byte] = {
    in.map(_.toByte).toArray[Byte]
  }

  def run(): Unit = {
    println("Staring a new game thread.")
    val input = new BufferedSource(s.getInputStream)
    val output = new PrintStream(s.getOutputStream())
    try {
      Repl.loop(input, output, Rot13.translate)
    } finally {
      input.close()
      output.close()
      s.close()
    }

  }
}