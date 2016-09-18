package slack

import io.scalac.slack.MessageEventBus
import io.scalac.slack.bots.AbstractBot
import io.scalac.slack.common.{BaseMessage, Command, OutboundMessage}

class CalculatorBot(override val bus: MessageEventBus) extends AbstractBot {

  val possibleOperations = Map(
    "+" -> ((x: Double, y: Double) => x + y),
    "-" -> ((x: Double, y: Double) => x - y),
    "*" -> ((x: Double, y: Double) => x * y),
    "/" -> ((x: Double, y: Double) => x / y)
  )

  override def help(channel: String): OutboundMessage =
    OutboundMessage(channel,
      s"$name will help you to solve difficult math problems \\n" +
        "Usage: $calc {operation} {arguments separated by space}")

  override def act: Receive = {


    case Command("calc", operation :: args, message) if args.nonEmpty =>
      val op = possibleOperations.get(operation)

      val response = op.map(f => {
        val result = args.map(_.toDouble).reduceLeft(f(_, _))
        OutboundMessage(message.channel, s"Results is: $result")
      }).getOrElse(OutboundMessage(message.channel, s"No operation $operation"))

      publish(response)

    case Command("calc", xxx, message) =>
      publish(OutboundMessage(message.channel, s"No arguments specified!"))

    case Command(_, _, message) => {
      publish(OutboundMessage(message.channel, s"Wut?"))
    }

    case fub: BaseMessage =>
      log.error("Hello! xxx")
      publish(OutboundMessage(fub.channel, "Wut???"))
    case foo =>
      log.error("Hello! ")

  }
}