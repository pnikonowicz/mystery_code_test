package code_test

object Converter {
  trait Appendable {
    def append(number: Int): Int;
  }

  case class Symbol(value: Char) extends Appendable {
    def append(number: Int): Int = {
      3
    }
  }

  case class Number(value: Char) extends Appendable {
    def append(number: Int): Int = {
      shiftLeft(number) + charToDecimal(value)
    }

    def shiftLeft(input: Int): Int = {
      input * 10
    }

    def charToDecimal(input: Char): Int = {
      input match {
        case '0' => 0
        case '1' => 1
        case '2' => 2
        case '3' => 3
        case '4' => 4
        case '5' => 5
        case '6' => 6
        case '7' => 7
        case '8' => 8
        case '9' => 9
      }
    }
  }

  def mapToOperation(value: Char): Appendable = {
    Number(value)
  }

  def stringToInt(input: String): Int = {
    input.map(Number).foldLeft(0)((acc, operation) => operation.append(acc))
  }
}