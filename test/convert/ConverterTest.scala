package convert

import org.scalatest.FlatSpec

import convert.Converter.ConvertException;

class ConverterTest extends FlatSpec {

  "stringToInteger" should "handle single digit string" in {
    val input = "1"

    expect(1) {
      Converter.stringToInteger(input)
    }
  }

  "stringToInteger" should "handle multiple digit string" in {
    val input = "1234567890"

    expect(1234567890) {
      Converter.stringToInteger(input)
    }
  }

  "stringToInteger" should "handle negation symbol" in {
    val input = "-1"

    expect(-1) {
      Converter.stringToInteger(input)
    }
  }

  "stringToInteger" should "handle positive symbol" in {
    val input = "+1"

    expect(1) {
      Converter.stringToInteger(input)
    }
  }
  
  "stringToInteger" should "throw exception with invalid input" in {
    val input = "f"
      
    intercept[ConvertException] {
      Converter.stringToInteger(input)
    }
  }
}