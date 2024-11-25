import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class myStack<T> extends JFrame implements ActionListener
{
    JTextField t1,t2;
    JButton btn1,btn2;
    JPanel p1,p2,p3;
    Stack<T> s_ref;

    myStack(Stack<T> ob)
    {
        super("Himanshu");
        t1=new JTextField();
        t2=new JTextField();
        btn1=new JButton("Push");
        btn2=new JButton("Pop");
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        s_ref=ob;
        setLayout(new GridLayout(3,1));

        add(p1);
        add(p2);
        add(p3);

        p1.add(t1);
        p2.setLayout(new GridLayout(1,2));
        p1.setLayout(new GridLayout(1,1));
        p3.setLayout(new GridLayout(1,1));
        p2.add(btn1);
        p2.add(btn2);
        p3.add(t2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(s.equals("Push"))
        {
            s_ref.push((T)t1.getText());
            t1.setText("");
            t2.setText(s_ref.toString());
        }else if(s.equals("Pop"))
        {
            if(s_ref.isEmpty())
            {
                t2.setText("Stack is empty");
            }else{
                s_ref.pop();
                t2.setText(s_ref.toString());
            }
            
        }
    }
}

public class stackGUI {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<Integer>();
        myStack<Integer> m=new myStack<Integer>(s);
        m.setSize(500,500);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}