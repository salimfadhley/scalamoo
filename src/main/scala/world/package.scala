/**
  * Created by salim on 9/8/2016.
  */
package object world {

  def snGenratorFactory(): () => Int = {
    Iterator.from(0).next
  }


}
