class buffer {
    int[][] matrix1;
    int[][] matrix2;
    int[][] ans;
    int n;
    int m;
    int flag;

    buffer(int[][] x, int[][] y, int r, int c) {
        m = r;
        n = c;
        matrix1 = new int[m][n];
        matrix2 = new int[m][n];
        ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = x[i][j];
                matrix2[i][j] = y[i][j];
            }
        }
        flag = 1;
    }

    synchronized void put(int id,int []x)
    {
            for(int i=0;i<m;i++)
            {
                ans[i][id]=x[i];
            }
                notifyAll();
            
    }
    synchronized int [][] get(int id)
    {
        int ret[][]=new int[m][2];
        for(int i=0;i<m;i++)
        {
            ret[i][0]=matrix1[i][id];
            ret[i][1]=matrix2[i][id];
        }
        return ret;
    }
    void display()
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class matrix extends Thread{
    int id;
    buffer b;
    matrix(buffer d_b,int x)
    {
        id=x;
        b=d_b;
        start();
    }

    public void run()
    {
        int [][]info=new int[b.m][2];
        synchronized(b)
        {
            info=b.get(id);
        }
        int ans[]=new int [b.m];
        for(int i=0;i<b.m;i++)
        {
            ans[i]=info[i][0]+info[i][1];
        }
        synchronized(b)
        {
            b.put(id,ans);
        }
    }
}


public class matrixMain
{
    public static void main(String[] args) {
        int [][]m1=new int[3][3];
        int [][]m2=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                m1[i][j]=j+1;
                m2[i][j]=j+1;
            }
        }
        buffer b=new buffer(m1, m2, 3, 3);
        matrix m[]=new matrix[3];
        for(int i=0;i<3;i++)
        {
            m[i]=new matrix(b, i);
        }
        for(int i=0;i<3;i++)
        {
            try{
                m[i].join();
            }catch(InterruptedException ob)
            {
                System.out.println(ob);
            }
        }
        b.display();
    }
}
