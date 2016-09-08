package model

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 9/8/2016.
  */
class SNGeneratorSpec extends FlatSpec with Matchers {

  "SNGenerator" should "be able to spawn counters" in {
    val i: () => Int = snGenratorFactory()
    assert(i() == 0)
    assert(i() == 1)
  }

  "it" should "spawn generators which operate independently" in {
    val i: () => Int = snGenratorFactory()
    val j: () => Int = snGenratorFactory()
    assert(i() == 0)
    assert(i() == 1)
    assert(j() == 0)
    assert(i() == 2)
  }

}
