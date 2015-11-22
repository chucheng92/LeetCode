package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = {123};
		digits = new PlusOne().plusOne(digits);
		for (int a:digits)
			System.out.println(a);
	}
	
	public int[] plusOne(int[] digits) {
		if (digits==null) return null;
 		int tmp = digits[0]+1;
 		int end = getNumber(tmp);
 		Integer[] res1 = new Integer[end];
 		int[] res2 = new int[end];
 		while (end!=0) {
 			res1[end-1] = tmp%10;
 			end--;
 			tmp/=10;
 		}
 		Comparator<Integer> cmp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		};
		Arrays.sort(res1,cmp);
		for (int i=0; i<res1.length; i++) {
			res2[i] = res1[i].intValue();
		}
		return (res2);
	}
	private int getNumber(int n) {
		int count = 0; 
		while (n%10>0 || n/10!=0) {
			count++;
			n/=10;
		}
		return count;
	}
}
