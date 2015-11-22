package leetcode;

// sort colors
public class SortColors {
	public static void main(String[] args) {
		int[] nums={0,2,2,1,1};
		int[] nums2={1,1,2,2,0};
		new SortColors().sortColors(nums);
		new SortColors().sortColors2(nums2);
		for (int a:nums)
			System.out.print(a+" ");
		System.out.println("********");
		for (int a:nums2)
			System.out.print(a+" ");
	}
	
	// O(nlogn)
	public void sortColors(int[] nums) {
		if (nums==null || nums.length<2)
			return;
		quicksort(nums, 0, nums.length-1);
	}
	
	// one pass + O(1)空间
	public void sortColors2(int[] nums) {
		if (nums==null || nums.length<2)
			return;
		int low = 0;
		int high = nums.length-1;
		for (int i=low; i<=high; ) {
			if (nums[i]==0) {
				int tmp = nums[i];
				nums[i] = nums[low];
				nums[low] = tmp;
				low++;i++;
			} else if (nums[i]==2) {
				int tmp = nums[i];
				nums[i] = nums[high];
				nums[high] = tmp;
				high--;
			} else {
				i++;
			}
		}
	}
	
	// random quicksort
	private void quicksort(int[] a, int left, int right) {
		if (left<right) {
			int point = (int)Math.random()*(right-left+1)+left;
			int tmp = a[point];
			a[point] = a[left];
			a[left] = tmp;
			
			int low = left;
			int high = right;
			int key = a[left];
			while (low < high) {
				while (low<high && a[high]>=key) high--;
				a[low] = a[high];
				while (low<high && a[low]<=key) low++;
				a[high] = a[low];
			}
			a[low]=key;
			quicksort(a, left, low-1);
			quicksort(a, low+1, right);
		}
	}
	
}
