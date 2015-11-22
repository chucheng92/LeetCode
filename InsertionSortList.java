package leetcode;

//Insertion Sort List
public class InsertionSortList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		ListNode res = new InsertionSortList().insertionSortList2(l1);
		while (res!=null) {
			System.out.println(res.val);
			res=res.next;
		}
	}

	// 可以过 但是是交换的方法
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = head.next;
		int min = head.val;
		while (q != null) {
			p=head;
			while (p != q) {
				if (q.val < p.val) {
					if (q.val < min) {
						min=q.val;
						head=q;
					}
					p.next = q.next;
					q.next = p;
					p = q;
					if (p.next==null)
						q=null;
					else q = p.next.next;
				} else {
					p = p.next;
				}
			}
			q = q.next;
		}
		return head;
	}
	
	// 插入的方法
	public ListNode insertionSortList2(ListNode head) {
		if (head==null || head.next==null) return head;
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		ListNode curr = head;
		ListNode next = null;
		
		while (curr!=null) {
			next=curr.next;
			while (pre.next!=null && pre.next.val<curr.val) {
				pre=pre.next;
			}
			curr.next=pre.next;
			pre.next=curr;
			pre = dummy;
			curr=next;
		}
		return dummy.next;
	}
}
