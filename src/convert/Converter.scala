package convert

object Converter {
  class ConvertException extends RuntimeException("invalid string format")
  
  trait Appendable {
    def append(number: Int): Int;
  }

  case class Symbol(value: Int => Int) extends Appendable {
    def append(number: Int): Int = {
      value(number)
    }
  }

  case class Number(value: Int) extends Appendable {
    def append(number: Int): Int = {
      shiftLeft(number) + value
    }

    def shiftLeft(input: Int): Int = {
      input * 10
    }
  }

  def mapToOperation(value: Char): Appendable = {
    Number(value)
  }

  def stringToInt(input: String): Int = {
    val parsed = parseSymbol(input.iterator.next) match {
      case Some(symbol) => input.iterator.drop(1).map(parseDecimal).toList :+ symbol
      case None => input.map(parseDecimal).toList
    }
    
    parsed.foldLeft(0)((acc, appendable) => appendable.append(acc))
  }

  def parseDecimal(input: Char): Number = {
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
      case   _ => throw new ConvertException
    }
  }

  def parseSymbol(input: Char): Option[Symbol] = {
    input match {
      case '+' => Some(Symbol(+_))
      case '-' => Some(Symbol(-_))
      case   _ => None
    }
  }

}