/**
 * Created by Sagar on 8/30/16.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.


 */
public class MaximumSubarraySum {

    public int maxSubArray(int[] nums) {
        int size=nums.length;

        int dp[]=new int[size+1];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<size;i++)
        {

            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            if(dp[i]>max)
                max=dp[i];

        }
        return max;

    }

    public static void main(String args[])
    {
        MaximumSubarraySum sum= new MaximumSubarraySum();
        int a[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sum.maxSubArray(a));
    }


}
