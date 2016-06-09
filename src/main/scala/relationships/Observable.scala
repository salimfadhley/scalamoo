package relationships

/**
  * Created by salim on 05/06/2016.
  */
trait Observable {
  def observeContents:Iterator[Observable] = {
    Iterator.empty
  }

  def observe(intensity:Int):String
}
