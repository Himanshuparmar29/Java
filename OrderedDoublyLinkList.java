class node {
    int info;
    node next;

    node() {
        info=0;
        next=null;
    }
    node(int x)
    {
        info=x;
        next=null;
    }
    node add(int x)
    {
        node t=new node(x);
        node temp=this;
        node temp1=this;
        if(this.info>x){
            t.next=this;
            return t;
        }
        while(temp != null && temp.info < x)
        {
            temp1=temp;
            temp=temp.next;
        }
        if(temp==null)
        {
            temp1.next=t;
        }
        else
        {
            t.next=temp1.next;
            temp1.next=t;
        }
        return this;
    }


    void display()
    {
        node temp=this;
        do{
            System.out.println(temp.info+" ");
            temp=temp.next;
        }while(temp!=null);
    }
}

public class OrderedDoublyLinkList {
    public static void main(String[] args) {
        node head=new node(201);
        head=head.add(4);
        head=head.add(71);
        head=head.add(18);
        head=head.add(37);
        head=head.add(30);
        head=head.add(29);
        head.display();
    }
}
