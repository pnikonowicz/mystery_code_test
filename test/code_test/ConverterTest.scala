package code_test

import org.scalatest.FlatSpec
import code_test.Converter.ConvertException

class ConverterTest extends FlatSpec {

  "stringToInt" should "handle single digit string" in {
    val input = "1"

    expect(1) {
      Converter.stringToInt(input)
    }
  }

  "stringToInt" should "handle multiple digit string" in {
    val input = "1234567890"

    expect(1234567890) {
      Converter.stringToInt(input)
    }
  }

  "stringToInt" should "handle negation symbol" in {
    val input = "-1"

    expect(-1) {
      Converter.stringToInt(input)
    }
  }

  "stringToInt" should "handle positive symbol" in {
    val input = "+1"

    expect(1) {
      Converter.stringToInt(input)
    }
  }
  
  "stringToInt" should "throw exception with invalid input" in {
    val input = "f"
      
    intercept[ConvertException] {
      Converter.stringToInt(input)
    }
  }
  
  "symbol" should "convert to a negative number" in {
    expect(-1) {
      Converter.Symbol(-_).append(1)
    }
  }
}