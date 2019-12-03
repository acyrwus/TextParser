package textParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParserTest {

	@Test
	void test() {
		
		//right r = new right("Test\nTest", 80, false);
		//System.out.println(r.rightOut());
		
		Parser parser = new Parser();
		System.out.println("FINAL OUTPUT\n" +parser.parse("Test"+System.lineSeparator() + "-w+" + System.lineSeparator() + "-b3" + System.lineSeparator() + "Text Text Text" + System.lineSeparator() + "Text" + System.lineSeparator() + "Text"));

	}

}
