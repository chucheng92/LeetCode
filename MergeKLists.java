package leetcode;

import java.util.Arrays;

public class MergeKLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		ListNode s1 = new ListNode(2);
		ListNode s2 = new ListNode(4);
		ListNode s3 = new ListNode(6);
		s1.next = s2;
		s2.next = s3;
		ListNode q1 = new ListNode(1);
		ListNode q2 = new ListNode(3);
		ListNode q3 = new ListNode(5);
		ListNode q4 = new ListNode(7);
		q1.next = q2;
		q2.next = q3;
		q3.next = q4;
		
		ListNode[] lists = {l1,s1,q1};
		ListNode res = new MergeKLists().mergeKLists(lists);
		while (res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
		System.out.println("******");
		for (ListNode a:lists) {
			System.out.println(a.val);
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (null==lists||0==lists.length) return null;
		if (1==lists.length) return lists[0];
		if (2==lists.length) return mergeTwoLists(lists[0], lists[1]);
		return mergeTwoLists(
			mergeKLists(Arrays.copyOfRange(lists, 0, lists.length/2)),
			mergeKLists(Arrays.copyOfRange(lists, lists.length/2, lists.length))
			);
	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (null == l1) return l2;
		if (null == l2) return l1;
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		while (l1!=null && l2!=null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		
		if (l1!=null) p.next = l1;
		else p.next = l2;
		
		return head.next;
	}
}
