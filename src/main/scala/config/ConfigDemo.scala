package config

/**
  * Created by salim on 18/09/2016.
  */
object ConfigDemo extends App {

  override def main(args: Array[String]): Unit = {
    printf(Config.foo.toString)
  }

}
