class buffer{
    int info;
    int [] turn;
    int c;
    buffer()
    {
        turn=new int[5];
        c=0;
        info=0;
        turn[0]=1;
    }

    synchronized void put(int []x,int id)
    {
        try{
            while (turn[id]!=1) {
                wait();
            }
            for(int i=0;i<5;i++)
            {
                System.out.println(x[i]+" ");
            }
            turn[id]=0;
            turn[(id+1)%turn.length]=1;
            info=x[x.length-1];
            notifyAll();
        }catch(InterruptedException ob)
        {
            System.out.println(ob);
        }
    }

    synchronized int get(int id)
    {
        try{
            while(turn[id]!=1)
            {
                wait();
            }
        }catch(InterruptedException ob)
        {
            System.out.println(ob);
        }
        return info;
    }
}

class prime extends Thread{
    int id;
    buffer b_ref;
    prime(int x,buffer d_ref)
    {
        id=x;
        b_ref=d_ref;
        start();
    }

    public void run()
    {
        int info;
        synchronized(b_ref)
        {
            info=b_ref.get(id)+1;
        }
        int a[]=new int[5];
        int c=0;
        while(true)
        {
            int flag=0;
            for(int j=2;j<info;j++)
            {
                if(info%j==0)
                {
                    flag=1;
                }
            }
            if(flag!=1)
            {
                a[c++]=info;
            }
            info++;
            if(c==5)
            {
                break;
            }
        }
        synchronized(b_ref)
        {
            b_ref.put(a,id);
        }
    }
}


public class primeNumber
{
    public static void main(String[] args) {
        buffer b=new buffer();
        prime [] p=new prime[3];
        for(int i=0;i<3;i++)
        {
            p[i]=new prime(i,b);
        }
        for(int i=0;i<3;i++)
        {
            try{
                p[i].join();
            }catch(InterruptedException ob)
            {
                System.out.println(ob);
            }
        }
    }
}
