package repl


import java.io.PrintStream

import scala.io.BufferedSource

/**
  * Created by sal on 09/07/16.
  */
object Repl extends App {

  print("Hello World!")

  override def main(args: Array[String]): Unit = {
    loop(
      new BufferedSource(System.in),
      System.out,
      Rot13.translate
    )
  }

  def loop(i: BufferedSource, o: PrintStream, processLine: (String) => String, runCondition: () => Boolean = () => true): Unit = {
    i.getLines().foreach((line: String) => {
      o.write(processLine(line).toCharArray.map(_.toByte))
    })
  }

}

