package compare_algorithm;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Compare_util_stringTest {

	@Test
	final void testGet_LCS_string() {
		//fail("Not yet implemented"); // TODO
		String test = Compare_util_string.get_LCS_string("1234","2345");
		Assertions.assertEquals("234", test);
	}

	@Test
	final void testSyntax_Analysis_diff() {
		//fail("Not yet implemented"); // TODO
		List<String> test = Compare_util_string.syntax_Analysis_diff("1234 2345", "2345 3456");
		Assertions.assertTrue(test.contains("1234"));
	}

	@Test
	final void testSyntax_Analysis_identical() {
		//fail("Not yet implemented"); // TODO
		List<String> test = Compare_util_string.syntax_Analysis_identical("1234 2345 4444", "2345 44");
		Assertions.assertTrue(test.contains("2345"));
	}

	@Test
	final void testGet_similarity() {
		//fail("Not yet implemented"); // TODO
		float l_similarity = Compare_util_string.get_similarity("12345 abcde", "12346 abcde", Compare_util_string.parsing_option.LEXICAL);
		float s_similarity = Compare_util_string.get_similarity("12345 abcde", "12346 abcde", Compare_util_string.parsing_option.SYNTAX);
		float line_similarity = Compare_util_string.get_similarity("12345 abcde", "12346 abcde", Compare_util_string.parsing_option.LINE);
		
		Assertions.assertEquals(0.9f, l_similarity);
		Assertions.assertEquals(0.5, s_similarity);
		Assertions.assertEquals(0, line_similarity);
	}

}
