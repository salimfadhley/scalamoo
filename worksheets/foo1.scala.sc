class Relationship(name:String, _inverse: =>Relationship) {
  lazy val inverse = _inverse
}

val foo:Relationship = new Relationship(name="Foo", new Relationship(name="Bar", foo))
printf(foo.toString)
printf(foo.inverse.toString)
assert(foo.inverse.inverse == foo)