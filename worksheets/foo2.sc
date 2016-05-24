def fod(): Int ={
  println("Fod called\n")
  3
}


def foo(x: =>Int): List[Int] = List(x+1, x+2)


foo(fod())

