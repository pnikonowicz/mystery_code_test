package convert

object PlusSymbol extends Symbol(+_)
object MinusSymbol extends Symbol(-_)

case class Symbol(value: Int => Int) extends Appendable {
  def append(number: Int): Int = {
    value(number)
  }
}