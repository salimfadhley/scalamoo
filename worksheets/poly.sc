import shapeless.PolyDefns.~>
import shapeless.{HList, HNil}
val a = List(1,2,3) :: List("a", "b", "c") :: List(true, false, true) :: HNil

object broken extends (HList ~> HList) {
  def apply[T](n:Int, l:HList): HList = {
    // I want to pick out the nth element of each HList
    // so in the above example, if n==1
    // I want to return
    // 2 :: "b" :: false :: HNil
    ???
  }
}

broken(1,a)
