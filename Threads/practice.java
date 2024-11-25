public class practice {
    public static void main(String[] args) {
        buffer b=new buffer();
        produce[] p=new produce[2];
        consume [] c=new consume[2];
        p[0]=new produce(0, b);
        p[1]=new produce(1, b);
        c[0]=new consume(0, b);
        c[1]=new consume(1, b);
    }
}

class buffer
{
    int info;
    int flag;

    buffer()
    {
        flag=0;
        info=0;
    }

    synchronized void put(int n,int i)
    {
        try{
            if(flag==1)
            {
                wait();
            }
            System.out.println("produce by : "+ i);
            info=n;
            flag=1;
            notify();
        }catch(InterruptedException ob)
        {
            System.out.println(ob);
        }
    }

    synchronized void get(int id)

    {
        try{
            if(flag==0)
            {
                wait();
            }
            flag=0;
            System.out.println(info+ " Consume by "+id);
            notify();
        }catch(InterruptedException ob)
        {
            System.out.println(ob);
        }
    }
}

class produce extends Thread
{
    buffer b_ref;
    int id;
    produce(int i,buffer ob)
    {
        b_ref=ob;
        id=i;
        start();
    }

    public void run()
    {
        b_ref.put(id+1, id);
    }
}

class consume extends Thread
{
    buffer b_ref;
    int id;

    consume(int i,buffer ob)
    {
        b_ref=ob;
        id=i;
        start();
    }

    public void run()
    {
        b_ref.get(id);
    }
}