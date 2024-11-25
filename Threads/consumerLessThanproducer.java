class buffer
{
    int[] flag;
    int[] info;
    int n=21;
    buffer(int n)
    {
        flag=new int[n];
        info=new int[n];
    }

    synchronized void put(int id,int x,int cid)
    {
        try{
            while(flag[cid]!=0)
            {
                wait();
            }
            System.out.println("Producer : "+(id+1)+" Produce : "+x+" For consumer : "+cid);
            flag[cid]=1;
            info[cid]=x;
            notifyAll();
            n--;
        }catch(InterruptedException ie)
        {
            System.out.println(ie);
        }
    }

    synchronized int get(int id)
    {
        if(n==0)
        {
            return 0;
        }
        try{
            while(flag[id]!=1)
            {
                wait();
            }
            System.out.println(info[id]+" Consumed by "+id);
            flag[id]=0;
            notifyAll();
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie);
        }
        return 1;
    }
}

class producer extends Thread
{
    int id;
    buffer b_ref;

    producer(buffer d1,int di)
    {
        id=di;
        b_ref=d1;
        start();
    }

    public void run()
    {
        for(int i=0;i<3;i++)
        {
            b_ref.put(id, i+1, (id%3));
        }
    }
}

class consumer extends Thread
{
    int id;
    buffer b_ref;

    consumer(buffer d_ref,int di)
    {
        b_ref=d_ref;
        id=di;
        start();
    }

    public void run()
    {
        synchronized(b_ref)
        {
            int n=b_ref.get(id);
            while(n==1)
            {
                n=b_ref.get(id);
            }
        }
        
    }
}

public class consumerLessThanproducer
{
    public static void main(String[] args) {
        buffer b=new buffer(3);
        producer p[]=new producer[7];
        consumer c[]=new consumer[3];
        p[0]=new producer(b, 0);
        p[1]=new producer(b, 1);
        p[2]=new producer(b, 2);
        p[3]=new producer(b, 3);
        p[4]=new producer(b, 4);
        p[5]=new producer(b, 5);
        p[6]=new producer(b, 6);

        c[0]=new consumer(b, 0);
        c[1]=new consumer(b, 1);
        c[2]=new consumer(b, 2);

        
    }
}
