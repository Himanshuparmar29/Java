import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Hashtable;
class myClass
{
    String name;
    int rank;
}
class myFrame extends JFrame implements ActionListener
{
    String id;
    myClass stu;
    JTextField t1,t2,t3;
    JButton btn1,btn2,btn3,btn4;
    JLabel l1,l2,l3;
    JPanel p1,p2;
    Hashtable<String,myClass> h_ref;
    myFrame(){
        h_ref=new Hashtable<String,myClass>(10,(float)0.7);
        stu=new myClass();
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        btn1=new JButton("Store");
        btn2=new JButton("Get");
        btn3=new JButton("Update");
        btn4=new JButton("Remove");
        l1=new JLabel("Id: ");
        l2=new JLabel("Name: ");
        l3=new JLabel("Rank: ");
        p1=new JPanel();
        p2=new JPanel();
        add(p1);
        add(p2);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(btn4);
        setLayout(new GridLayout(2,1));
        p1.setLayout(new GridLayout(1,6));
        p2.setLayout(new GridLayout(1,3));
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(s.equals("Store"))
        {
            id=t1.getText();
            stu.name=t2.getText();
            stu.rank=Integer.parseInt(t3.getText());
            h_ref.put(id,stu);
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }else if(s.equals("Get")){
            id=t1.getText();
            if(h_ref.get(id)==null){
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }else{
                stu=h_ref.get(id);
                t2.setText(stu.name);
                t3.setText(Integer.toString(stu.rank));
            }
            
        }else if(s.equals("Update")){
            id=t1.getText();
            stu.name=t2.getText();
            stu.rank=Integer.parseInt(t3.getText());
            h_ref.put(id,stu);
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }else if(s.equals("Remove"))
        {
            id=t1.getText();
            h_ref.remove(id);
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
    }
}
public class HashTableGUI {
    public static void main(String[] args) {
        myFrame m=new myFrame();
        m.setSize(800,500);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
