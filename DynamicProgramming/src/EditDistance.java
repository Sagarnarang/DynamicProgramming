/**
 * Created by Sagar on 8/29/16.
 */
public class EditDistance {
    public int editDistance(String a,String b)
    {
        int sizeA=a.length(),sizeB=b.length();
        int memArr[][]=new int[sizeB+1][sizeA+1];
        for(int i=0;i<=sizeA;i++)
        {
            memArr[0][i]=i;

        }
        for(int i=0;i<=sizeB;i++)
        {
            memArr[i][0]=i;

        }
        for(int i=1;i<=sizeB;i++)
        {
            for(int j=1;j<=sizeA;j++)
            {
             if(b.charAt(i-1)==a.charAt(j-1))
                 memArr[i][j]=memArr[i-1][j-1];
                else
             {
                 memArr[i][j]=1+Math.min(memArr[i-1][j-1],Math.min(memArr[i][j-1],memArr[i-1][j]));
             }
            }
        }
        System.out.println("   "+a);
        for(int i=0;i<sizeB+1;i++)
        {
            System.out.print(i+ "  ");
            for(int j=0;j<sizeA+1;j++)
            {
                System.out.print(memArr[i][j]);
            }
            System.out.println("");
        }

        System.out.println("------------");
        findString(a,b,memArr,sizeA,sizeB);
        return memArr[sizeB][sizeA];
    }

    public void findString(String a,String b,int memArr[][],int sizeA, int sizeB)
    {
        for(int i=sizeB;i>0;)
        {
            for(int j=sizeA;j>0;)
            {
                if(b.charAt(i-1)==a.charAt(j-1))
                {
                    i--;
                    j--;
                }
                else{
                    int top=memArr[i-1][j];
                    int diag=memArr[i-1][j-1];
                    int left=memArr[i][j-1];
                    int min=Math.min(top,Math.min(diag,left));

                    if(min==top)
                    {
                        System.out.println("DELETE "+b.charAt(i-1));
                        i--;
                    }
                    else if(min==left)
                    {
                        System.out.println("DELETE "+a.charAt(j-1));
                        j--;
                    }
                    else
                    {
                        System.out.println("REPLACE "+b.charAt(i-1)+","+a.charAt(j-1));
                        i--;j--;
                    }

                }
            }
        }
    }

    public static void main(String args[])
    {
        EditDistance d= new EditDistance();
        System.out.println("SOLUTION-->"+d.editDistance("azced","abcdef"));
    }

}
