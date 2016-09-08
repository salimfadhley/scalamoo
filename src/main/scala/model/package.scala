/**
  * Created by salim on 9/8/2016.
  */
package object model {

  def snGenratorFactory(): () => Int = {
    Iterator.from(0).next
  }


}
