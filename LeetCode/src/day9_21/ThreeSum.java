package day9_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
* @author 作者  小小刘
* @version 创建时间：2018年9月21日 下午9:48:49
* 类说明
*/
public class ThreeSum {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> ret = ts.threeSum(nums);
		
		for (List<Integer> list : ret) {
			System.out.println(ret);
		}
	}
	
	  public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		
		if (nums != null &&nums.length >2) {
			
			//首先对数组进行排序
			Arrays.sort(nums);
			//我们假设取第 i 个数为结果
			for(int i= 0;i<nums.length-2;)
			{
				//第二个数的可能起始位置
				int j = i+1;
				//第三个数的可能起始位置
				int k = nums.length - 1;
				
				while (j < k) {
					if (nums[j] + nums[k] == -nums[i]) {
						//当我们找到满足条件的解时，我们将结果添加到结果集里
						List<Integer> list = new ArrayList<>(3);
						
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						result.add(list);
						//移动位置寻找下一组解
						k--;
						j++;
						
						//下面两个while是用来判断是否越界和判断移动后的数是否和之前的数相同，若相同则跳过该数
						while (j<k && nums[j] == nums[j-1]) {
							j++;
						}
						while (j<k&&nums[k] == nums[k+1]) {
							k--;
						}
					}
					//和大于 0，让k向前移动到小一点的数
					else if (nums[j]+nums[k]>-nums[i]) {
						k--;
						//下面是用来判断是否越界和判断移动后的数是否和之前的数相同，若相同则跳过该数
						while (j<k&&nums[k] == nums[k+1]) {
							k--;
						}
					}
					//和小于 0，让j向后移动到大一点的数
					else {
						j++;
						//下面是用来判断是否越界和判断移动后的数是否和之前的数相同，若相同则跳过该数
						while (j<k&&nums[j] == nums[j-1]) {
							j++;
						}
					}
				}
				//指向下一个要处理的数
				i++;
				//从左向右找第一个与之前处理的数的不同的数的下标
				while (i<nums.length-2&&nums[i] == nums[i-1]) {
					i++;
				}
			}
		}
		  
		  return result;
	        
	   }
}
