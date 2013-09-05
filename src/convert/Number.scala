package convert

case class Number(value: Int) extends Appendable {
  def append(number: Int): Int = {
    shiftLeft(number) + value
  }

  def shiftLeft(input: Int): Int = {
    input * 10
  }
}