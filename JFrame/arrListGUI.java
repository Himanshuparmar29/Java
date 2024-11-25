import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class myClass <T> extends JFrame implements ActionListener
{
    JTextField t1,t2;
    JButton btn1,btn2,btn3;
    ArrayList<T> al_ref;
    JPanel p1,p2,p3;
    myClass(ArrayList<T> ob)
    {
        t1=new JTextField();
        t2=new JTextField();
        btn1=new JButton("Add");
        btn2=new JButton("Set");
        btn3=new JButton("Remove");
        al_ref=ob;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        setLayout(new GridLayout(3,1));
        p1.setLayout(new GridLayout(1,1));
        p2.setLayout(new GridLayout(1,3));
        p3.setLayout(new GridLayout(1,1));
        add(p1);
        add(p2);
        add(p3);
        p1.add(t1);
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p3.add(t2);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(s.equals("Add"))
        {
            al_ref.add((T)(t1.getText()));
            t1.setText("");
            t2.setText(al_ref.toString());
        }else if(s.equals("Remove")){
            if(!al_ref.remove((T)(t1.getText()))){
                t1.setText("Not exist");
            }
            else{
                al_ref.remove((T)(t1.getText()));
                t1.setText("");
                t2.setText(al_ref.toString());
            }
        }
    }
}

public class arrListGUI
{
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<Integer>(5);
        myClass<Integer> m=new myClass<Integer>(a);
        m.setSize(500,500);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}