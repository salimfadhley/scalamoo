package parser

import game.{Movable, Player, World}

/**
  * Created by salim on 12/08/2016.
  */
class Parser(subject:Movable) {
  def parse(instruction: String): Unit = {

    val instructionParts:List[String] = instruction.split("\\s+").toList

    instructionParts match {
      case Seq("go", direction) => subject.moveDirection(direction)
      case _ => throw new ParserException(s"Cannot parse: ${instruction}")
    }
  }


}
