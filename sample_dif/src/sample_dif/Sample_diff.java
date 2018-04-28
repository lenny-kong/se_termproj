package sample_dif;

import java.util.*;

public class Sample_diff {

	public static void main(String[] args) {
		List<String> sample = new ArrayList<String>();
		// TODO Auto-generated method stub
		Diff dif = new Diff();
		String a = "The most valuable man in the world.";
		String b = "The tiny valuable girl in the universe.";
		sample = dif.syntax_Analysis(a, b);
		System.out.println(sample);
	}
}
