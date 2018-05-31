package common_util_lib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilityTest {

	@Test
	void testReverse() {
		List<Object> actual = new ArrayList<Object>();
		actual.add(new Object());
		actual.add(new Object());
		actual.add(new Object());
		actual.add(new Object());
		Assertions.assertEquals(actual, Utility.reverse(Utility.reverse(actual)));
	}

	@Test
	void testMax_numIntInt() {
		Assertions.assertEquals(9, Utility.max_num(9, 7));
	}

	@Test
	void testMax_numFloatFloat() {
		Assertions.assertEquals(9.9f, Utility.max_num(9.9f, 7.9f));
	}

	@Test
	void testMax_numFloatFloatFloat() {
		Assertions.assertEquals(10.4f, Utility.max_num(9.9f, 7.9f, 10.4f));
	}

	@Test
	void testMax_num_index() {
		Assertions.assertEquals(0, Utility.max_num_index(11.9f, 7.9f, 10.4f));
		Assertions.assertEquals(1, Utility.max_num_index(9.9f, 12.9f, 10.4f));
		Assertions.assertEquals(2, Utility.max_num_index(9.9f, 7.9f, 10.4f));
	}

	@Test
	void testBool_reverse() {
		Assertions.assertTrue(Utility.bool_reverse(false));
	}

}
