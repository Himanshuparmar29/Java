import java.applet.*;
import java.awt.*;
public class appletDemo extends Applet
{
    String name="";
    public void init()
    {
        name+="Himanshu";
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawString(name, 10, 20);
    }
}
