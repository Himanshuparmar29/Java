class node{
    int info;
    node next;
    node pre;
    node(){
        info=0;
        next=null;
        pre=null;
    }
    node(int x)
    {
        info=x;
        next=null;
        pre=null;
    }

    node add(int x)
    {
        node t=new node(x);
        if(this.info >= x){
            t.next=this;
            this.pre=t;
            return t;
        }
        node temp=this;
        while(temp.next!=null && temp.info<x)
        {
            temp=temp.next;
        }
        if(temp.next==null && temp.info < x){
            temp.next=t;
        }
        else{
            t.next=temp;
            t.pre=temp.pre;
            temp.pre.next=t;
            temp.pre=t;
        }
        
        return this;
    }

    void traverse()
    {
        node temp=this;
        do{
            System.out.println(temp.info+" ");
            temp=temp.next;
        }while(temp!=null);
    }
}
public class doublyLinkList {
    public static void main(String[] args) {
        String[] s1;
    //    System.out.println(s1.length); 
        // node head=new node(201);
        // head=head.add(4);
        // head=head.add(71);
        // head=head.add(18);
        // head=head.add(37);
        // head=head.add(30);
        // head=head.add(29);
        // head.traverse();
        // System.out.println(-7>>1);
    }
}
