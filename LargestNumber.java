package leetcode;

import java.util.Arrays;
import java.util.Comparator;

// Largest Number
public class LargestNumber {
	public static void main(String[] args) {
		int[] nums={0,0,0,000,0000,0};
		System.out.println(new LargestNumber().largestNumber(nums));
	}
	
	public String largestNumber(int[] nums) {
		if (nums==null || nums.length==0) return "";
		String[] Snum = new String[nums.length];
		for (int i=0; i<nums.length; i++) {
			Snum[i]=nums[i]+"";
		}
		Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				return s1.compareTo(s2);
			}
		};
		Arrays.sort(Snum, cmp);
		
		StringBuilder sb= new StringBuilder();
		for (String a:Snum) {
			sb.insert(0, a);
		}
		if (sb.charAt(0)=='0') return "0";
		return sb.toString();
	}
}
