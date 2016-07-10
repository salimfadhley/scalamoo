package server

import java.util.concurrent.{ExecutorService, Executors}

/**
  * Created by sal on 10/07/16.
  */
object Main extends App {

  override def main(args: Array[String]): Unit = {
    val pool_size = 99
    val pool: ExecutorService = Executors.newFixedThreadPool(pool_size)

    val server = new GameServer(pool, 9991)

    pool.execute(server)


  }

}
