/**
 * Created by Sagar on 8/29/16.
 */

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

 */
public class StockProblem {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int arr[]=new int[prices.length+1];

        int max=0;
        int pricesofar=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>pricesofar)
            {
                max=Math.max(max,prices[i]-pricesofar);
            }
            else
            {
                pricesofar=prices[i];
            }


        }
        return max;
    }

    public static void main(String args[])
    {
        StockProblem s= new StockProblem();
        int arr[]={7, 1, 5, 3, 6, 4};
        System.out.println(s.maxProfit(arr));
    }
}
