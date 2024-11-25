class node
{
    int info;
    node next;
    node()
    {
        info=0;
        next=null;
    }
    node(int x)
    {
        info=x;
        next=this;
    }

    void add(int x)
    {
        node t=new node(x);
        node temp=this;
        // if(this.next==null){
        //     this.next=t;
        //     t.next=this;
        //     return;
        // }
        while(temp.next!=this)
        {
            temp=temp.next;
        }
        temp.next=t;
        t.next=this;
    }

    void display()
    {
        node temp=this;
        do{
            System.out.println(temp.info+" ");
            temp=temp.next;
        }while(temp!=this);
    }
}
public class circularLinkList {
    public static void main(String[] args) {
        node head=new node(201);
        head.add(4);
        head.add(71);
        head.add(18);
        head.add(37);
        head.add(30);
        head.add(29);
        head.display();
    }
}
