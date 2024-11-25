import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Hashtable;

class stuInfo 
{
    String gender;
    String oe;
    String pe;
}

class myFrame extends JFrame implements ActionListener,ItemListener
{
    stuInfo s_ref;
    Hashtable <String,stuInfo> h_ref;
    JLabel l1;
    JRadioButton r1,r2;
    JTextField t1;
    JComboBox b1,b2;
    JButton btn1,btn2;
    JPanel p1,p2,p3;
    ButtonGroup g1;
    myFrame()
    {
        super("Himanshu");
        h_ref = new Hashtable<String,stuInfo>(10, (float)0.8);
        s_ref = new stuInfo();
        l1 = new JLabel("Id");
        r1 = new JRadioButton("M");
        r2 = new JRadioButton("F");
        g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);

        // Set Action Commands for Radio Buttons
        // r1.setActionCommand("M");
        // r2.setActionCommand("F");

        btn1 = new JButton("Store");
        btn2 = new JButton("Get");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        b1 = new JComboBox();
        b2 = new JComboBox();
        t1 = new JTextField();
        setLayout(new GridLayout(3,1));

        // Add components to panels
        p1.add(l1);
        p1.add(t1);
        p1.add(r1);
        p1.add(r2);
        p3.add(btn1);
        p3.add(btn2);
        add(p1);
        add(p2);
        add(p3);
        p2.add(b1);
        p2.add(b2);
        p1.setLayout(new GridLayout(1,4));
        p2.setLayout(new GridLayout(1,2));
        p3.setLayout(new GridLayout(1,2));

        // Set options for JComboBoxes
        b1.addItem("Select OE");
        b1.addItem("OE-1");
        b1.addItem("OE-2");
        b1.addItem("OE-3");
        b1.addItem("OE-4");
        b1.setSelectedIndex(0);
        b1.addItemListener(this);

        b2.addItem("Select PE");
        b2.addItem("PE-1");
        b2.addItem("PE-2");
        b2.addItem("PE-3");
        b2.addItem("PE-4");
        b2.setSelectedIndex(0);
        b2.addItemListener(this);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        r1.addActionListener(this);
        r2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        String s = ae.getActionCommand();
        // t1.setText("Gender");
        if(s.equals("M"))
        {
            s_ref.gender = "Male";
            //t1.setText(s_ref.gender);
        } 
        else if(s.equals("F"))
        {
            s_ref.gender = "Female";
            //t1.setText(s_ref.gender);
        } 
        else if(s.equals("Store"))
        {
            String id = t1.getText();
            h_ref.put(id, s_ref);  // Store current student's info
            s_ref = new stuInfo();  // Create a new stuInfo object for next entry
            t1.setText("");
            r1.setSelected(false);
            r2.setSelected(false);
            b1.setSelectedIndex(0);
            b2.setSelectedIndex(0);
        } 
        else if(s.equals("Get"))
        {
            s_ref = h_ref.get(t1.getText());
            if(s_ref.gender.equals("Male"))
            {
                r1.setSelected(true);
            }
            else
            {
                r2.setSelected(true);
            }
            b1.setSelectedItem(s_ref.oe);
            b2.setSelectedItem(s_ref.pe);
        }
    }

    public void itemStateChanged(ItemEvent ie){
        JComboBox temp = (JComboBox)ie.getSource();
        if(temp == b1)
        {
            s_ref.oe = (String)b1.getSelectedItem();
        }
        else if(temp == b2)
        {
            s_ref.pe = (String)b2.getSelectedItem();
        }
    }
}

class studentGUI 
{
    public static void main(String[] args) {
        myFrame m = new myFrame();
        m.setSize(800,500);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
