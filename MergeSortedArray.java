package leetcode;

// Merge Sorted Array
public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1= new int[9];
		int[] nums2 = new int[4];
		
		for (int i=0; i<4; i++)
			nums2[i]=i+5;
		new MergeSortedArray().merge(nums1, 4, nums2, 4);
		for (int a:nums1)
			System.out.println(a);
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while (i>=0 && j>=0) {
			if (nums1[i]>nums2[j])
				nums1[k--]=nums1[i--];
			else
				nums1[k--]=nums2[j--];
		}
		while (j>=0)
			nums1[k--]=nums2[j--];
	}
}
