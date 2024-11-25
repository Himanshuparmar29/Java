class buffer {
    int[] a;
    int c = 0;
    int[] turn;
    int[] info;

    buffer(int n, int th_n) {
        a = new int[n];
        turn = new int[th_n];
        info = new int[2];
        turn[0] = 1;
        info[0] = 0;
        info[1] = 1;
    }

    synchronized void put(int id, int[] x) {
        try {
            while (turn[id] != 1) {
                wait();
            }
            for (int i = 0; i < 10; i++) {
                a[c++] = x[i];
            }
            info[0] = a[c - 2];
            info[1] = a[c - 1];
            turn[id] = 0;
            turn[(id+1)%turn.length] = 1; 
            notifyAll();
        } catch (InterruptedException ob) {
            System.out.println(ob);
        }
    }

    synchronized int[] get(int id) {
        try {
            while (turn[id] != 1) {
                wait();
            }
        } catch (InterruptedException ob) {
            System.out.println(ob);
        }
        notifyAll();
        return info;
    }

    int getC() {
        return c;
    }

    void display() {
        for (int i = 0; i < c; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

class fibonacci implements Runnable {
    int id;
    int[] a;
    Thread th;
    buffer b_ref;

    fibonacci(int x, buffer d_ref) {
        a = new int[10];
        th = new Thread(this);
        id = x;
        b_ref = d_ref;
        th.start();
    }

    public void run() {
        int[] info;
        synchronized (b_ref) {
            info = b_ref.get(id);
        }
        int a = info[0];
        int b = info[1];
        int c;

        int[] fib = new int[10];
        for (int i = 0; i < 10; i++) {
            c = a + b;
            fib[i] = c;
            a = b;
            b = c;
        }

        synchronized (b_ref) {
            b_ref.put(id, fib);
        }
    }
}

public class fibonacciMain {
    public static void main(String[] args) {
        buffer b = new buffer(100, 10);
        fibonacci[] f = new fibonacci[10];

        for (int i = 0; i < 10; i++) {
            f[i] = new fibonacci(i, b);
        }

        for (int i = 0; i < 10; i++) {
            try {
                f[i].th.join();
            } catch (InterruptedException ob) {
                System.out.println(ob);
            }
        }

        b.display();
    }
}
