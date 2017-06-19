package interact


/**
  * Created by salim on 6/19/2017.
  */
object Main extends App {

  def fnInteract(s:String):String = s"Hello $s\n"

  val i = new Interaction(fnInteract)

  i.interact(System.in, System.out)

}
