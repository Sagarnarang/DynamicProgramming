import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Sagar on 8/31/16.
 */
public class HexCoding {
HashMap<Character,Integer> map= new HashMap<Character,Integer>();
    public void readInput() throws IOException
    {
       BufferedReader br= new BufferedReader(new FileReader("/Users/Sagar/Downloads/input.txt"));
        String t;
        int i=0;
        while((t=br.readLine())!=null)
        {
            //System.out.println(i++);
            if(!checkCase(t))
                System.out.println("CORRUPTED");
            else{
                System.out.println(decode(t));
            }


        }


    }


public String decode(String str)
{
    String val= new String();
    for(int i=0;i<str.length();)
    {
        Character c= new Character(str.charAt(i));
        //System.out.println("-->"+c);
        if(c=='\\')
        {
            Character d= new Character(str.charAt(i+1));
            if(i+2==str.length())
                return "CORRUPTED";
            Character next= new Character(str.charAt(i+2));
            int rep=0;
            if(!(d>=65 &&d<=70))
                rep=Character.getNumericValue(d);
            else{
                rep=map.get(d);
            }
            int x=rep+3;
           // System.out.println(next);
            for(int j=0;j<x;j++)
                val=val.concat(""+next);
            i=i+3;

        }
        else
        {
            val=val.concat(""+c);
            i++;
        }
      //  System.out.println("val="+val);

    }
    return val;
}
    public boolean checkCase(String str)
    {
        for(int i=0; i<str.length(); i++){
            Character c = str.charAt(i);
            Character d= new Character('s');
            if(i<str.length()-2)
                d=new Character(str.charAt(i+1));
            if(c >= 97 && c <= 122) {
                return false;
            }
            if((i<str.length()-2 && c=='\\'))
            {
                if(!(Character.isDigit(d)||(d>=65 &&d<=70))) {

               //System.out.println(c+","+d);
                return false;
            }
            if(str.charAt(i+2)=='\\')
                return false;
            }
            if(!c.isLetter(c) && !c.isDigit(c) && c!='\\')
                return false;

        }
        if(str.charAt(str.length()-1)=='\\')
            return false;
        return true;
    }

    public static void main(String args[]) throws IOException {
        HexCoding h= new HexCoding();
        h.map.put('A',10);
        h.map.put('B',11);
        h.map.put('C',12);
        h.map.put('D',13);
        h.map.put('E',14);
        h.map.put('F',15);
        h.readInput();
    }

}
