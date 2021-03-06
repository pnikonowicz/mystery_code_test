package convert

object Converter {
  class ConvertException extends RuntimeException("invalid string format")

  def stringToInteger(input: String): Int = {
    val tokens = input.map(char => parseSymbol(char) match {
      case Some(symbol) => symbol
      case None => parseNumber(char)
    }).toList
    
    tokens match {
      case (symbol:Symbol) :: tail => (foldAppendablesToInt _ andThen symbol.append)(tail) 
      case numbers => foldAppendablesToInt(numbers) 
    }
  }

  def foldAppendablesToInt(numbers:List[Appendable]) : Int = {
    numbers.foldLeft(0)((int, appendable) => appendable.append(int))
  }
  
  def parseNumber(input: Char): Number = input match {
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

  def parseSymbol(input: Char): Option[Symbol] = input match {
    case '+' => Some(PlusSymbol)
    case '-' => Some(MinusSymbol)
    case _ => None
  }

}