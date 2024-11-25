public class MultiplePAndC {
    public static void main(String[] args) {
        int n=2;
        buffer b=new buffer(n);
        producer [] p=new producer[n];
        consumer[] c=new consumer[n];
        for(int i=0;i<n;i++)
        {
            p[i]=new producer(b,i);
            c[i]=new consumer(b, i);
        }
        for(int i=0;i<n;i++)
        {
            try{
                p[i].th_ref.join();
                c[i].th_ref.join();
            }
            catch(InterruptedException ob){
                System.out.println("Error occured while joining");
            }
        }
    }
}

class buffer {
    int[] item;
    int[] flag;

    buffer(int n) {
        item = new int[n];
        flag = new int[n];
    }

    synchronized void put(int info, int cId,int pId) {
        try {
            while (flag[cId] != 0) {
                wait();
            }
            item[cId] = info;
            flag[cId] = 1;
            notifyAll();
            System.out.println("Item"+info+" produce by producer "+pId+" for consumer "+cId);
        } catch (InterruptedException ob) {
            System.out.println("Error occured while producing the item!");
        }
    }

    synchronized void get(int cId)
    {
        try{
            while(flag[cId]!=1)
            {
                wait();
            }
            System.out.println("Item"+item[cId]+" consumed by consumer "+cId);
            flag[cId]=0;
            notifyAll();
        }catch (InterruptedException ob) {
            System.out.println("Error occured while consuming the item!");
        }

    }
}

class producer implements Runnable
{
    static int c=0;
    int p_id;
    buffer b_ref;
    Thread th_ref;
    producer(buffer d_b,int p_id)
    {
        this.p_id=p_id+1;
       b_ref=d_b;
       th_ref=new Thread(this);
       th_ref.start(); 
    }

    public void run()
    {
        for(int i=0;i<2;i++)
        {
            b_ref.put(++c,(i%2),p_id);
        }
    }
}

class consumer implements Runnable
{
    int cId;
    buffer b_ref;
    Thread th_ref;

    consumer(buffer d_b,int id)
    {
        b_ref=d_b;
        cId=id;
        th_ref=new Thread(this);
        th_ref.start();
    }

    public void run()
    {
        for(int i=0;i<2;i++)
        {
            b_ref.get(cId);
        }
    }
}