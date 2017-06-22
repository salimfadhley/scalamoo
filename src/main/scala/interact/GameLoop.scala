package interact

import java.io._

import scala.io.Source

/**
  * Created by salim on 6/19/2017.
  */
class GameLoop(interactionFunction:(String)=>String) extends Interaction {


  override def interact(io:InputOutput): Unit = {
    for (s <- io.in) {
      io.out(interactionFunction(s))
    }
  }
}


