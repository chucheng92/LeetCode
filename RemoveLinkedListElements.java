package leetcode;

//remove Linked List Elements
public class RemoveLinkedListElements {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;	
		l3.next = l4;	
		l4.next = l5;	
		l5.next = l6;	
		l6.next = l7;
		ListNode s1 = new ListNode(1);
		s1.next = null;
		ListNode res = new RemoveLinkedListElements().removeElements2(l1, 6);
		while (res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	//常规方法
	public ListNode removeElements(ListNode head, int val) {
		if (head==null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy, curr=head;
		while (curr!=null) {
			if (curr.val==val)
				pre.next=curr.next;
			else 
				pre=pre.next;
			curr = curr.next;
		}
		return dummy.next;
	}
	//递归方法
	public ListNode removeElements2(ListNode head, int val) {
		if (head==null) return null;
		head.next = removeElements(head.next, val);
		return head.val==val?head.next:head;
	}
}
