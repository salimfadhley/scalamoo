package config

import com.typesafe.config.{ConfigFactory, Config => Config_}

/**
  * Created by salim on 18/09/2016.
  */
object Config {
  val conf: Config_ = ConfigFactory.load();
  val foo = conf.getInt("xxx")
}
