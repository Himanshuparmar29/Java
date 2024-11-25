import java.util.*;

class akar {
    double d1;
    double d2;

    akar() {
        d1 = 0;
        d2 = 0;
    }

    akar(double x, double y) {
        d1 = x;
        d2 = y;
    }

    void display() {
        System.out.println("D1 : " + d1);
        System.out.println("D2 : " + d2);
    }

    double cal() {
        return d1 * d2;
    }
}

class triangle extends akar {
    triangle() {
        super();
    }

    triangle(double x, double y) {
        super(x, y);
    }

    double cal() {
        return 0.5 * d1 * d2;
    }
}

class rectangle extends akar {
    rectangle() {
        super();
    }

    rectangle(double x, double y) {
        super(x, y);
    }

    double cal() {
        return d1 * d2;
    }
}

public class shape {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the dimensions : ");
            double x = in.nextInt();
            double y = in.nextInt();
            try {
                if (x < 0 || y < 0)
                    throw new ArithmeticException();
                akar ob = new rectangle(x, y);
                System.out.println("Your answer is : "+ ob.cal());
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
    }
}
