/*
 * Add Two Numbers
 * 17/09/04 11:53:17 
 */

public class Solution {

	//自己实现
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode next1 = l1;
		ListNode next2 = l2;
		ListNode result = null;
		ListNode nextListNode = null;

		while (next1 != null || next2 != null) {
			if (result == null) {
				result = new ListNode(0);
				nextListNode = result;
			} else {
				if (nextListNode.next == null)
					nextListNode.next = new ListNode(0);
				nextListNode = nextListNode.next;
			}

			int val1 = next1 == null ? 0 : next1.val;
			int val2 = next2 == null ? 0 : next2.val;
			int sum = val1 + val2 + nextListNode.val;
			if (sum < 10)
				nextListNode.val = sum;
			else {
				nextListNode.val = sum - 10;
				nextListNode.next = new ListNode(1);
			}

			//指向下一个节点
			next1 = next1 == null ? null : next1.next;
			next2 = next2 == null ? null : next2.next;
		}
		return result;
	}

	//Test
	public static void main(String args[]) {
		Solution s = new Solution();
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		ListNode l2 = new ListNode(1);

		ListNode output = s.addTwoNumbers(l1, l2);
		System.out.printf("{%d, %d, %d}", output.val, output.next.val, output.next.next.val);

	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}
