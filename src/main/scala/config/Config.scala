package config

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by salim on 18/09/2016.
  */
object Config {
  val conf: Config = ConfigFactory.load();
  val foo = conf.getInt("xxx")
}
