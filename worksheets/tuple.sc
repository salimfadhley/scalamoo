val foo0 = new Foo("Hello", "World")
// Does not work!
val (a: String, b: String) = foo0: (String, String)

implicit def asTuple(x: Foo): (String, String) = (x._a, x._b)

/**
  * Created by sal on 27/05/16.
  *
  **/

class Foo(a: String, b: String) {
  val _a: String = a
  val _b: String = b
}

