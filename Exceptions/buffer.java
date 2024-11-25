import java.util.*;
public class buffer {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int [] a;
        int s;
        System.out.print("Enter the size of buffer : ");
        s=in.nextInt();
        a=new int[s];
        int pos=1;
        int val=1;
        for(int i=0;i<s;i++)
        {
            a[i]=-1;
        }
        while( true )
        {
            System.out.print("Enter the position and Value : ");
            pos=in.nextInt();
            val=in.nextInt();
            try{
                if(val == 0 && pos == 0) break;
                if(pos > s-1 || pos < 0) throw new ArrayIndexOutOfBoundsException();
                if(a[pos]!=-1) throw new myException("Value at position "+ pos+" already exist!", val);
                if(val<0) throw new IllegalArgumentException();
                a[pos]=val;
            }
            catch(ArrayIndexOutOfBoundsException ob)
            {
                System.out.println("Please Enter valid position!");
            }
            catch(IllegalArgumentException ob)
            {
                System.out.println("Please Enter a Positive number");
            }
            catch(myException ob)
            {
                System.out.println(ob);
            }
        }
        System.out.print("Your Inputs : ");
        for(int i=0;i<s;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}

class myException extends Exception
{
    String msg;
    int no;

    myException(String s, int n)
    {
        super();
        msg=s;
        no=n;
    }

    public String toString()
    {
        return(" "+no+" : "+msg+"\n");
    }
}


