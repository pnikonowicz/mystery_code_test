package convert

case class Symbol(value: Int => Int) extends Appendable {
  def append(number: Int): Int = {
    value(number)
  }
}