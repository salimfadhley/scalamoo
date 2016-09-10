package model

import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

/**
  * Created by salim on 9/9/2016.
  */
class GraphSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  var w: World = null


  override def beforeEach(): Unit = {
    super.beforeEach()
    w = World.factory()
  }

  "Things" can "be joined together to make edges" in {
    val r0 = w.newRoom
    val r1 = w.newRoom
    val e = w.addEdge(r0, r1)
  }


}
