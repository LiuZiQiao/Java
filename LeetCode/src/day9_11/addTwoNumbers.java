package day9_11;
/**
* @author 作者  小小刘
* @version 创建时间：2018年9月11日 下午10:47:49
* 类说明
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class addTwoNumbers {

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l1 = null;
		add(l1,1);
		add(l1,1);
		add(l1,1);
		ListNode l2 = null;
		add(l2,1);
		add(l2,1);
		add(l2,1);
		ListNode ret = s.addTwoNumbers(l1, l2);
		System.out.println(ret);
		}
	public static void add(ListNode list,int val) {
		ListNode node = new  ListNode(val);
		if (list == null) {
			list = node;
		}
		else {
			list.next = node;
		}
		list = node;
	}

}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode root = new ListNode(0);
    	ListNode rear = root;
    	int carry = 0;
    	if (l1 == null) {
			return l2;
		}
    	if (l2 == null) {
			return l1;
		}
    	
    	while(l1!=null&&l2!=null)
    	{
    		int ret = (l1.val+l2.val)%10;
    		ListNode node = new ListNode(ret);
    		rear.next = node;
    		carry = (l1.val+l2.val+carry)/10;
    		rear = node;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	
    	if (l1 == null) {
			rear.next = l2;
		}
    	else {
			rear.next = l1;
		}
    	
    	if (carry == 1) {
			while(rear.next!=null)
			{
				int sum = (rear.next.val+carry);
				rear.next.val = sum%10;
				
				carry = sum/10;
				rear =rear.next;
			}
			if (carry == 1) {
				rear.next = new ListNode(0);
			}
    	}
    	return root.next;
    }
}


