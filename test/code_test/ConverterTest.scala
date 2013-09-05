package code_test

import org.scalatest.FlatSpec

class ConverterTest extends FlatSpec {

	"stringToInt" should "handle single digit string" in  {
		val input = ""
		
		val actual = Converter.stringToInt(input)
	}
	
	"stringToInt" should "handle multiple digit string" in {
	  
	}
	
	"stringToInt" should "handle negation symbol" in {
	  
	}
	
	"stringToInt" should "handle positive symbol" in  {
	  
	}
}