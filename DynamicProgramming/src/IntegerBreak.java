/**
 * Created by Sagar on 8/29/16.
 */

/** Given a positive integer n, break it into the sum of at least two positive
   integers and maximize the product of those integers.
    Return the maximum product you can get
 */

public class IntegerBreak {
    public int integerBreak(int n)
    {
        int memArr[]=new int[n+1];
        memArr[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<i;j++)
            {
                memArr[i]=Math.max(memArr[i],Math.max(memArr[j],j)*Math.max(memArr[i-j],i-j));

            }
        }

        return memArr[n];
    }

    public static void main(String args[])
    {
        IntegerBreak i=new IntegerBreak();
        System.out.println(i.integerBreak(10));
    }
}
