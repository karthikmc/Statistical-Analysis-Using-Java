/*
 * @author Santhosh Kumar
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CorrelationTypes
{
    JFrame frame= new JFrame("STATISTICS");
    JLabel crrTypes;
    JLabel crrDescription;
 
    CorrelationTypes() 
    {
        setComponents();
        addComponentsToFrame();
    }
 
    public void setComponents()
    {     
        crrTypes = new JLabel("CORRELATION TYPES");
        crrTypes.setBounds(250, 40, 300, 50);
        crrTypes.setFont(new Font("Serif", Font.BOLD, 25));
        
        crrDescription = new JLabel(new ImageIcon("src\\correlationtypes.png"));
        crrDescription.setBounds(20, 0, 750, 750);
    }
    
    public void addComponentsToFrame() 
    {
        frame.add(crrTypes);
        frame.add(crrDescription);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(600, 150, 800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE );
    }

    public static void main(String[] args) throws Exception
    {
        new CorrelationTypes();
    }

}
