/**
 * Created by Sagar on 8/29/16.
 */

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n)
    {
        int dpArr[]=new int[n+1];
        dpArr[0]=0;
        dpArr[1]=1;
        if(n>=2)
            dpArr[2]=2;

        for(int i=3;i<=n;i++)
        {
            dpArr[i]=dpArr[i-1]+dpArr[i-2];
        }
        return dpArr[n];

    }

    public static void main(String args[])
    {
        ClimbingStairs stairs=new ClimbingStairs();
        System.out.println(stairs.climbStairs(4));
    }
}
