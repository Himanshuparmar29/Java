import java.util.Scanner;
class fact
{
    public static void main(String[] args) {
        System.out.print("Enter a number : ");
        Scanner in = new Scanner(System.in);
        double num=in.nextDouble();
        System.out.println("Your answer is(using static method) "+factorial(num));
        in.close();
        factorialClass fc=new factorialClass();
        System.out.println("Your answer is(using class method) "+fc.factC(num));
    }
    static double factorial(double x)
    {
        double ans=1;
        while(x>0)
        {
            ans*=x;
            x--;
        }
        return ans;
    }
}
