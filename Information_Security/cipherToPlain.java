import java.util.Scanner;

public class cipherToPlain {
    public static void main(String[] args) {
        System.out.print("Enter the Cipher text : ");
        Scanner in=new Scanner(System.in);
        String cipherText=in.nextLine();
        int i=0;
        StringBuilder plainText =new StringBuilder(cipherText);
        while(i<cipherText.length())
        {
            char ch=cipherText.charAt(i);
            if(ch < 123 && ch>96)
            {
                ch=(char)((ch -'a'-3+26)%26 + 'a');
                plainText.setCharAt(i, ch);
            }
            i++;
        }
        System.out.println(plainText);
    }
}
