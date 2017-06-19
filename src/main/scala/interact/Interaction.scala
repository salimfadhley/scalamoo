package interact

import java.io._

import scala.io.Source

/**
  * Created by salim on 6/19/2017.
  */
class Interaction(interactionFunction:(String)=>String) {

  def interact(in:InputStream, out:PrintStream): Unit = {
    for (s <- Source.fromInputStream(in).getLines()) {
      out.print(interactionFunction(s))
    }
  }

}


