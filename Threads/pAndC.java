//write a program in which we have two producer and two consumer. Each producer 10 iteams at once 4 times and specify which consumer should consume.
class buffer {
    int[] a;
    int n;
    int[] flag;

    buffer() {
        a = new int[10];
        flag = new int[2];
        n = 8;
    }

    synchronized void put(int[] x, int id, int n) {
        try {
            while (flag[id] == 1) {
                wait();
            }
            for (int i = 0; i < n; i++) {
                a[i] = x[i];
            }
            flag[id] = 1;
            notifyAll();
            n--;
        } catch (InterruptedException ob) {
            System.out.println("Exception in producing item!");
        }
    }

    synchronized int get(int id, int n) {
        try {
            if (n == 0) {
                return 0;
            }
            while (flag[id] == 0) {
                wait();
            }
            for (int i = 0; i < n; i++) {
                System.out.println("consumer " + (id + 1) + " : " + a[i]);
            }
            flag[id] = 0;
            notifyAll();
        } catch (InterruptedException ob) {
            System.out.println("Exception in consuming the item!");
        }
        return 1;
    }
}

class producer implements Runnable {
    buffer b_ref;
    Thread th_ref;

    producer(buffer d_b) {
        b_ref = d_b;
        th_ref = new Thread(this);
        th_ref.start();
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            int[] a = new int[10];
            for (int j = 0; j < 10; j++) {
                a[j] = j + 1;
            }
            if (i < 3)
                b_ref.put(a, 0, 10);
            else
                b_ref.put(a, 1, 10);

        }
    }

    class consumer implements Runnable {
        int id;
        buffer b_ref;
        Thread th;

        consumer(int x, buffer d_ref) {
            b_ref = d_ref;
            id = x;
            th = new Thread(this);
            th.start();
        }

        public void run() {
            int flag = b_ref.get(id, 10);
            while (flag == 1) {
                b_ref.get(id, 10);
            }
        }
    }
}

public class pAndC
{
    public static void main(String[] args) {
        buffer b=new buffer();
        producer p1=new producer(b);
        producer p2=new producer(b);
        consumer c1=new consumer(0, b);
        consumer c2=new consumer(1, b);
        try{
            p1.th_ref.join();
            p2.th_ref.join();
            c1.th.join();
            c2.th.join();
        }catch(InterruptedException ob)
        {
            System.out.println("Exception in main!");
        }
    }
}