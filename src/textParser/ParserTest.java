package textParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParserTest {

	@Test
	void test() {
		
		//right r = new right("Test\nTest", 80, false);
		//System.out.println(r.rightOut());
		
		Parser parser = new Parser();
		System.out.println("FINAL OUTPUT\n" +parser.parse("Test test" + System.lineSeparator() + "Test2 test2" + System.lineSeparator() + "Text3 Text3 Text3" + System.lineSeparator() +"-p4"+ System.lineSeparator() +  "Text4 Text4 Text4 Text4 Text4" + System.lineSeparator() + "Text5 text5"));

	}
}
