/*
 * Add Two Numbers
 * 17/09/04 11:53:17 
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

public class Solution {

	//Approach #1
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode next1 = l1;
		ListNode next2 = l2;
		ListNode result = null;
		ListNode current = null;

		while (next1 != null || next2 != null) {

			//还有下一个节点，才会创建新的ListNode, 链到result上
			if (result == null) {
				result = new ListNode(0);
				current = result;
			} else {
				if (current.next == null)
					current.next = new ListNode(0);
				current = current.next;
			}

			int val1 = next1 == null ? 0 : next1.val;
			int val2 = next2 == null ? 0 : next2.val;
			int sum = val1 + val2 + current.val;
			if (sum < 10)
				current.val = sum;
			else {//相加超过10，创建下一个ListNode(1)，链到result上
				current.val = sum - 10;
				current.next = new ListNode(1);
			}

			//指向下一个节点
			next1 = next1 == null ? null : next1.next;
			next2 = next2 == null ? null : next2.next;
		}
		return result;
	}

	//Approach #2
	public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
		ListNode next1 = l1;
		ListNode next2 = l2;
		ListNode result = new ListNode(0);
		ListNode current = result;

		int sum = 0;
		int carry = 0;//用来标识是否有进位
		while (next1 != null || next2 != null) {
			sum = carry;
			if (next1 != null) {
				sum += next1.val;
				next1 = next1.next;
			}
			if (next2 != null) {
				sum += next2.val;
				next2 = next2.next;
			}
			carry = sum / 10;
			current.next = new ListNode(sum % 10);
			current = current.next;
		}
		if (carry > 0)
			current.next = new ListNode(carry);
		return result.next;
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

