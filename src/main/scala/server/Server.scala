import java.io.{InputStream, OutputStream}
import java.net.ServerSocket

import scala.concurrent.Future
import scala.util.Try

import scala.concurrent.ExecutionContext.Implicits.global

object Server extends App{
  val acceptor = new ServerSocket(2223)

  def serve(getInputStream: InputStream, getOutputStream: OutputStream): Unit = {
    getOutputStream.write("ddddd".toByte)
  }

  while(true) {
    val socket = acceptor.accept
    val f:Future[Unit] = Future { serve(socket.getInputStream, socket.getOutputStream )}
    f.onComplete((triedUnit: Try[Unit]) =>socket.close())
  }
}

