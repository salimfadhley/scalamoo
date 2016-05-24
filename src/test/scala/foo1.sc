class Relationship(name:String, _inverse:Relationship) {
  lazy val inverse = _inverse
}

lazy val foo:Relationship = new Relationship(name="Foo", new Relationship(name="Bar", foo))
assert(foo == foo.inverse.inverse)
