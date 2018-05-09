package compare_algorithm;

public class Test_class {

	public static void main(String[] args) {		
		Compare_util_string_list differ1 = new Compare_util_string_list("compare_1.txt","compare_2.txt", Compare_util_string.parsing_option.LEXICAL, 0.89f);
		differ1.print_List();
	}
}
