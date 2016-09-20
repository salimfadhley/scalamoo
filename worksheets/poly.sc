import shapeless._


val a = List(1,2,3) :: List("a", "b", "c") :: List(true, false, true) :: HNil

trait RowSelect[L <: HList] extends DepFn2[L, Int] {
  type Row <: HList
  type Out = Option[Row]
}

object RowSelect {
  type Aux[L <: HList, Row0 <: HList] = RowSelect[L] {type Row = Row0}
  implicit val hnilRowSelect: Aux[HNil, HNil] = new RowSelect[HNil] {
    type Row = HNil

    def apply(l: HNil, i: Int): Option[HNil] = Some(HNil)
  }

  def select[L <: HList](l: L, i: Int)(implicit rs: RowSelect[L]): rs.Out = rs(l, i)

  implicit def hconsRowSelect[A, T <: HList](implicit
                                             trs: RowSelect[T]
                                            ): Aux[List[A] :: T, A :: trs.Row] = new RowSelect[List[A] :: T] {
    type Row = A :: trs.Row

    def apply(l: List[A] :: T, i: Int): Option[A :: trs.Row] = for {
      h <- l.head.lift(i)
      t <- trs(l.tail, i)
    } yield h :: t
  }
}

