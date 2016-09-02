import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Sagar on 9/1/16.
 */
public class switchNumbers {

    public int solution(int X)
    {
        int returnAnswer=X;
        String intX=Integer.toString(X);
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<intX.length();i++)
            arr.add(intX.charAt(i)-'0');
        for(int i=1;i<arr.size();i++)
        {
            int retVal=0;
            if(arr.get(i-1)>arr.get(i))
                retVal=getIntFromList(arr,true,i);
            else
                retVal=getIntFromList(arr,false,i);
            if(retVal<returnAnswer)
                returnAnswer=retVal;
        }
        return returnAnswer;
    }

    public int getIntFromList(ArrayList<Integer> arr,boolean flag,int k)
    {
        String temp="";
        if(flag==true)
        {
            for(int i=0;i<arr.size();i++) {
                if(i!=k)
                temp = temp.concat(Integer.toString(arr.get(i)));
            }
        }
        else
        {
            for(int i=0;i<arr.size();i++) {
                    temp = temp.concat(Integer.toString(arr.get(i)));
            }
        }
        return Integer.parseInt(temp);
    }

    public static void main(String args[])
    {
        switchNumbers num= new switchNumbers();
        System.out.println(num.solution(233614));
    }
}
