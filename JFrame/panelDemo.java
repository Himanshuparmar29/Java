import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myFrame extends JFrame implements ActionListener,ItemListener
{
    JPanel p1,p2;
    JCheckBox c1,c2;
    JTextField t1,t2,t3;
    JButton btn1,btn2;
    String s="";
    myFrame()
    {
        super("Himanshu");
        p1=new JPanel();
        p2=new JPanel();
        c1=new JCheckBox("A");
        c2=new JCheckBox("B");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        btn1=new JButton("Read");
        btn2=new JButton("Clear");
        setLayout(new GridLayout(2,1));
        p1.setLayout(new GridLayout(2,3));
        p2.setLayout(new GridLayout(2,4));
        add(p1);
        add(p2);
        p1.add(c1);
        p1.add(c2);
        p1.add(t1);
        p2.add(t2);
        p2.add(btn1);
        p2.add(btn2);
        p2.add(t3);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        c1.addItemListener(this);
        c2.addItemListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String t=ae.getActionCommand();
        if(t.equals("Read")){
            t3.setText(t2.getText());
            t2.setText(" ");

        }else if(t.equals("Clear")){
            t2.setText("");
            t3.setText("");
        }

    }
    public void itemStateChanged(ItemEvent ie){
        JCheckBox t=(JCheckBox)ie.getSource();
        if(t==c1){
            if(c1.isSelected()){
                s="A is selected!";
            }else{
                s="A is Deselected!";
            }
        }else if(t==c2){
            if(c2.isSelected()){
                s="B is selected!";
            }else{
                s="B is Deselected!";
            }
        }
        t1.setText(s);
    }
}

public class panelDemo {
    public static void main(String[] args) {
        myFrame ref=new myFrame();
        ref.setSize(500,500);
        ref.setVisible(true);
        ref.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
