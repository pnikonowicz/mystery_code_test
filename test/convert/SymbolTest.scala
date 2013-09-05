package convert

import org.scalatest.FlatSpec

class SymbolTest extends FlatSpec {
  "symbol" should "convert to a negative number" in {
    expect(-1) {
      Symbol(-_).append(1)
    }
  }
}