package leetcode;

// Sort List
public class SortList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		ListNode res = new SortList().sortList2(l1);
		while (res!=null) {
			System.out.println(res.val);
			res=res.next;
		}
	}
	
	// 超时
	public ListNode sortList1(ListNode head) {
		if (head==null) return null;
		if (head.next==null) return head;
		
		ListNode p = head;
		ListNode q = head.next;
		while (q!=null) {
			p=head;
			while (p!=q) {
				if (q.val<p.val) {
					int tmp = p.val;
					p.val = q.val;
					q.val = tmp;
					p=p.next;
				} else {
					p=p.next;
				}
			}
			q=q.next;
		}
		return head;
	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1==null) return l2;
		if (l2==null) return l1;
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		while (l1!=null && l2!=null) {
			if (l1.val<l2.val) {
				p.next=l1;
				l1=l1.next;
			} else {
				p.next=l2;
				l2=l2.next;
			}
			p=p.next;
		}
		if (l1!=null) p.next=l1;
		else p.next=l2;
		
		return head.next;
	}
	
	// 拆分＋递归 调用合并两个有序表的算法 归并
	public ListNode sortList2(ListNode head) {
		if (head==null || head.next==null) return head;
		ListNode p = head;
		ListNode q = head.next.next;
		
		while (q!=null && q.next!=null) {
			p=p.next;
			q=q.next.next;
		}
		
		ListNode right = sortList2(p.next);
		p.next=null;
		ListNode left = sortList2(head);
		return mergeTwoLists(left, right);
	}
	
}
