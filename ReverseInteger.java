package leetcode;

// reverse integer
public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(-123));
		System.out.println("*******");
		int a = Integer.MAX_VALUE;
		int b=a+1;
		int c=b-1;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

	public int reverse(int x)
	{
	    int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
}
