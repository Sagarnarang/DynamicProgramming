import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Sagar on 9/1/16.
 */
public class calLength {
    public int solution(String S)
    {
        String arr[]=S.split("\n");
        ArrayList<String> list=  new ArrayList<>(Arrays.asList((arr)));
        System.out.println(list);
        HashMap<Integer,String> map= new HashMap<>();
        int max=0;
        for(int i=0;i<list.size();i++)
        {
            String curr=list.get(i);
            int spaces=countSpaces(curr);
            map.put(spaces,"\\"+curr.trim());
            if(curr.matches(".*jpeg|.*gif|.*png"))
            {

                max=max+ calculateSum(map,spaces);
            }

        }
        return max;
    }

    public int calculateSum(HashMap<Integer,String> map, int spaces)
    {
        int sum=0;
        System.out.println("spaces="+spaces+map);
        for(int i=0;i<=spaces;i++)
        {
            sum=sum+map.get(i).length();
        }
        System.out.println(sum);
        return sum;

    }
    public int countSpaces(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(Character.isWhitespace(s.charAt(i)))
                count++;
        }
        return count;
    }

    public static void main(String args[])
    {
        calLength c= new calLength();
        System.out.println(c.solution("dir1\n" +
                " dirl1\n" +
                " dirl2\n" +
                "  picture.jpeg\n" +
                "  dir121\n" +
                "  file1.txt\n"+"dir2\n" +
                " file2.gif"));
    }
}
