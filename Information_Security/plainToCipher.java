import java.util.Scanner;
class plainToCipher
{
    public static void main(String [] args)
    {
        System.out.print("Enter the Plain text : ");
        Scanner in=new Scanner(System.in);
        String plainText=in.nextLine();
        int i=0;
        StringBuilder cipherText=new StringBuilder(plainText);
        while(i<plainText.length())
        {
            char ch=plainText.charAt(i);
            if(ch < 123 && ch>96)
            {
                ch=(char)((ch -'a'+3)%26 + 'a');
                cipherText.setCharAt(i, ch);
            }
            i++;
        }
        System.out.println(cipherText);
    }
}