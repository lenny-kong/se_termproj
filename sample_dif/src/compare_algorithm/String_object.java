/*
 * Basic Construct for diff, merge or other method. 
 */
package compare_algorithm;

public class String_object {
	
	public enum Modified_status
	{
		NOCHANGE,
		INSERT,
		DELETE,
		SIMILAR,
	};
	
	private String string;
	private Modified_status status;
	private String_object similar_string_object;
	
	/*
	 * Constructor
	 */
	public String_object(String string, Modified_status status)
	{
		this.string = string;
		this.status = status;
	}
	
	public String_object(String string)
	{
		this.string = string;
		this.status = Modified_status.NOCHANGE;
	}
	
	public String_object(String string, String_object similar_string_object)
	{
		this.string = string;
		this.status = Modified_status.SIMILAR;
		this.similar_string_object = similar_string_object;
	}

	/*
	 * Getter
	 */
	public String get_string() 
	{
		return this.string;
	}
	
	public Modified_status get_status() 
	{
		return this.status;
	}
	
	public String_object get_similar_string_object() 
	{
		return this.similar_string_object;
	}
	
}
