package leetcode;

public class SingleNumber {
	public static void main(String[] args) {
		int[] nums = {2,2,2,1};
		int res = singleNumber(nums);
		System.out.println(res);
	}

	public static int singleNumber(int[] nums) {
		// k=3 p=1
		int x1 = 0;
		int x2 = 0;
		int mask = 0;
		
		for (int i:nums) {
			x2 ^= x1&i;
			x1 ^= i;
			mask = ~(x1&x2);
			x2 &= mask;
			x1 &= mask;
		}
		
		return x1;
	}
	
}
