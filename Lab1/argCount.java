public class argCount {
   public static void main(String[] args) {
    int c=0;
    for(int i=0;i<args.length;i++)
    {
        System.out.print(args[i]+" ");
        c++;
    }
    System.out.println("\nThere are total "+ c +" arguments.");

   } 
}
