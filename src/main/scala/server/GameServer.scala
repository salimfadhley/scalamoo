package server

import java.net.ServerSocket
import java.util.concurrent.ExecutorService

/**
  * Created by sal on 10/07/16.
  */
class GameServer(pool: ExecutorService, server_port: Int) extends Runnable {

  override def run(): Unit = {
    val server: ServerSocket = new ServerSocket(server_port)
    println(s"Server is listening on ${server.getLocalPort}.")
    while (true) {
      println("Waiting for the next connection... ")
      pool.execute(new GameThread(server.accept()))
    }

  }

}
