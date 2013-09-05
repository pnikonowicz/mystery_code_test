package convert

import org.scalatest.FlatSpec

import convert.Converter.ConvertException;

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
}