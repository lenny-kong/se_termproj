package compare_algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import compare_algorithm.Compare_util_string_list;

import org.junit.jupiter.api.Test;

class Compare_util_string_listTest {

	@Test
	void testCompare_util_string_listStringStringParsing_optionFloat() {
		
		Compare_util_string_list actual_lexical_90 = new Compare_util_string_list(
				"compare_1.txt", 
				"compare_2.txt", 
				Compare_util_string.parsing_option.LEXICAL, 
				0.9f
				);

		Compare_util_string_list actual_syntax_90 = new Compare_util_string_list(
				"compare_1.txt", 
				"compare_2.txt",
				Compare_util_string.parsing_option.LEXICAL,
				0.9f
				);
		
		Compare_util_string_list actual_line = new Compare_util_string_list(
				"compare_1.txt", 
				"compare_2.txt",
				Compare_util_string.parsing_option.LINE,
				1.0f
				);

		for(int i = 0; i < actual_lexical_90.get_list_size(); i++) 
		{
			Assertions.assertEquals(
					actual_lexical_90.get_left_String_object_list().get(i).get_status(),
					actual_lexical_90.get_right_String_object_list().get(i).get_status()
					);
		}
		
		for(int i = 0; i < actual_syntax_90.get_list_size(); i++) 
		{
			Assertions.assertEquals(
					actual_syntax_90.get_left_String_object_list().get(i).get_status(),
					actual_syntax_90.get_right_String_object_list().get(i).get_status()
					);
		}
		
		for(int i = 0; i < actual_line.get_list_size(); i++) 
		{
			Assertions.assertEquals(
					actual_line.get_left_String_object_list().get(i).get_status(),
					actual_line.get_right_String_object_list().get(i).get_status()
					);
		}
	}

	@Test
	void testCompare_util_string_listStringString() {
		
		Compare_util_string_list actual = new Compare_util_string_list(
				"compare_1.txt", 
				"compare_2.txt"
				);
		for(int i = 0; i < actual.get_list_size(); i++) 
		{
			Assertions.assertEquals(
					actual.get_left_String_object_list().get(i).get_status(),
					actual.get_right_String_object_list().get(i).get_status()
					);
		}
	}

}
