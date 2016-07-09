package repl

/**
  * Created by sal on 09/07/16.
  */
object Rot13 {

  def translate(input: String): String = {
    input.map {
      case c if inRange(c, 'a', 'm') => c + 13 toChar
      case c if inRange(c, 'n', 'z') => c - 13 toChar
      case c => c
    }
  }

  def inRange(c: Char, start: Char, end: Char): Boolean = {
    start.toLower <= c.toLower && c.toLower <= end.toLower
  }
}
