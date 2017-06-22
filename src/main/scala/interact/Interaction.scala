package interact

import java.io.{InputStream, PrintStream}

/**
  * Created by sal on 21/06/17.
  */
trait Interaction {

  def interact(io:InputOutput): Unit

}
