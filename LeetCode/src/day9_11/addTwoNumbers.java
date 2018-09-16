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

		demo();
		}
	public static void demo() {
		Solution s = new Solution();
		ListNode l1 = null;
		l1.val = 1;
		l1.val = 1;
		l1.val = 1;
		
		ListNode l2 = null;
		l2.val = 2;
		l2.val = 2;
		l2.val = 2;
		ListNode ret = s.addTwoNumbers(l1, l2);
		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
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
    	
    	
    	while(l1 != null || l2 != null)
    	{
    		int d1 = l1 == null?0:l1.val;
    		int d2 = l2 == null?0:l2.val;
    		int sum = d1+d2+carry;
    		
    		rear.next =new ListNode(sum%10);
    		rear = rear.next;
    		
    		if (l1 != null) {
				l1 = l1.next;
			}
    		if (l2 != null) {
				l2 = l2.next;
			}
    	}
    	
    	if (carry == 1) {
			rear.next = new ListNode(1);
		}
    	return root.next;
    }
}


