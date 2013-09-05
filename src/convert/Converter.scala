package convert

object Converter {
  class ConvertException extends RuntimeException("invalid string format")

  def stringToInteger(input: String): Int = {
    val firstCharThatMayBeASymbol = input.charAt(0)
    val parsed = parseSymbol(firstCharThatMayBeASymbol) match {
      case Some(symbol) => input.iterator.drop(1).map(parseNumber).toList :+ symbol
      case None => input.map(parseNumber).toList
    }

    parsed.foldLeft(0)((acc, appendable) => appendable.append(acc))
  }

  def parseNumber(input: Char): Number = {
    input match {
      case '0' => Number(0)
      case '1' => Number(1)
      case '2' => Number(2)
      case '3' => Number(3)
      case '4' => Number(4)
      case '5' => Number(5)
      case '6' => Number(6)
      case '7' => Number(7)
      case '8' => Number(8)
      case '9' => Number(9)
      case _ => throw new ConvertException
    }
  }

  def parseSymbol(input: Char): Option[Symbol] = {
    input match {
      case '+' => Some(Symbol(+_))
      case '-' => Some(Symbol(-_))
      case _ => None
    }
  }

}