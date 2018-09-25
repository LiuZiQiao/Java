package day9_18;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.transform.Templates;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月18日 下午2:25:24
* 类说明
*/
public class RemoveDuplicates {

	public static void main(String[] args) {
		Solution s = new Solution();
		
 		int[] nums = {1,1,1,2,2};
		
		int ret =s.removeDuplicates2(nums);
		System.out.println(ret);
	}
}


class Solution
{
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
	
	public int removeDuplicates2(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		
		int i = 0;
		int j = 1;
		int count = 1;
		while(j<nums.length)
		{
			if (nums[i] == nums[j] && count == 0) {
				++j;
			}
			else 
			{
				if (nums[i] == nums[j]) {
				--count;
				}
				else {
					count = 1;
				}
				nums[++i] = nums[j++];
			}
		}
		return i+1; 
	}
}