package day9_19;

/**
 * @author 作者 小小刘
 * @version 创建时间：2018年9月19日 下午6:38:02 类说明
 */
public class Merge {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { 4, 5, 6 };

		merge1(nums1, 3, nums2, 3);

		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + " ");
		}
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1, j = n - 1;
		int index = m + n - 1;
		while (index >= 0) {
			if (i < 0) {
				nums1[index--] = nums2[j--];
			} else if (j < 0) {
				nums1[index--] = nums1[i--];
			} else if (nums1[i] < nums2[j] && i >= 0) {
				nums1[index--] = nums2[j--];
			} else if (nums1[i] > nums2[j] && j >= 0) {
				nums1[index--] = nums1[i--];
			}
		}
	}
	
	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		
		  int []res = new int[m+n];
	        int i=0,j=0,cnt=0;
	        //遍历两个数组，将较小的值依次赋给res数组
	        while(i<m && j<n){
	            if(nums1[i]<nums2[j])
	                res[cnt++] = nums1[i++];
	            else
	                res[cnt++] = nums2[j++];
	         }
	         //将未遍历完的数组的剩余元素赋给res数组
	        if(i>=m)
	            while(j<n) res[cnt++] = nums2[j++];    
	        if(j>=n)
	            while(i<m) res[cnt++] = nums1[i++];    
	         //由于要返回的是nums1数组，所以需要将res数组的值赋给nums1 
	        for(i=0;i<res.length;i++){         
	            nums1[i] = res[i];
	        }
	}
	
	public static void merge2(int[] nums1, int m, int[] nums2, int n)  {
		 int i = m - 1; //数组1的元素个数
	        int j = n - 1; //数组2的元素个数
	        int index = m + n -1; //数组1的元素个数+数组2的元素个数-1 = 数组1的总长度。用以存储1和2合并之后的数据
	 
	        while (i >= 0 && j >= 0) {
	            if (nums1[i] > nums2[j]) {  //大的往后移动，指针往前移一个
	                nums1[index] = nums1[i];
	                index = index - 1;
	                i = i - 1;
	            } else {
	                nums1[index] = nums2[j];
	                index = index - 1;
	                j = j - 1;
	            }
	        }
	 
	        //当上面循环结束后，num1或者num2可能还有数据没有进行比较/移动
	        //当num1中还有数据
	        while (i >= 0) {
	            nums1[index] = nums1[i];
	            index = index - 1;
	            i = i - 1;
	        }
	 
	        //同上
	        while (j >= 0) {
	            nums1[index] = nums2[j];
	            index = index - 1;
	            j = j - 1;

	        }
	}
}

