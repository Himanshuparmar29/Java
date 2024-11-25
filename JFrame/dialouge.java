import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class myFrame extends JFrame implements ActionListener {
    JDialog d1, d2;
    JMenuBar mb;
    JMenu menu;
    JMenuItem i1, i2;
    JButton btn1,btn2;
    myFrame()
    {
        d1=new JDialog(this,"For Item 1",true);
        d2=new JDialog(this,"For Item 2");
        d1.setSize(200,400);
        d2.setSize(200,400);
        d1.setVisible(false);
        d2.setVisible(false);
        // d1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // d2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mb=new JMenuBar();
        menu=new JMenu("M1");
        i1=new JMenuItem("I1");
        i2=new JMenuItem("I2");
        btn1=new JButton("Close1");
        btn2=new JButton("Close2");
        menu.add(i1);
        menu.add(i2);
        mb.add(menu);
        add(mb);
        setLayout(new GridLayout(6,1));

        i1.addActionListener(this);
        i2.addActionListener(this);
        d1.add(btn1);
        d2.add(btn2);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(s.equals("I1")){
            d1.setVisible(true);
        }else if(s.equals("I2"))
        {
            d2.setVisible(true);
        }else if(s.equals("Close1"))
        {
            d1.setVisible(false);
        }else if(s.equals("Close2"))
        {
            d2.setVisible(false);
        }
    }
}

class dialouge
{
    public static void main(String[] args) {
        myFrame m=new myFrame();
        m.setSize(800,500);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
} 