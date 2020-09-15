/*
 * @author Santhosh Kumar
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main implements ActionListener 
{
    JFrame frame = new JFrame("STATISTICS");
    JLabel head;
    JLabel crrTypes;
    JLabel crrHead;
    JLabel crrDescription;
    JLabel regHead;
    JLabel regDescription;
    JButton crrTypesButton;
    JButton crrButton;
    JButton regButton;
    JButton details;
    JLabel karthik1;
    JLabel karthik2;
    JLabel santhosh;

    Main()
    {
        setComponents();
        addComponentsToFrame();
        addActionEvent();
    }

    public void setComponents() 
    {
        head = new JLabel("Implementation of Statistical Concepts");
        head.setBounds(140, 10, 500, 50);
        head.setFont(new Font("Serif", Font.BOLD, 28));

        crrTypes = new JLabel("1. Correlation Types");
        crrTypes.setBounds(240, 80, 300, 50);
        crrTypes.setFont(new Font("Serif", Font.BOLD, 25));
        
        crrTypesButton = new JButton("Click Here");
        crrTypesButton.setBounds(300, 140, 120, 40);
        crrTypesButton.setFont(new Font("Serif", Font.BOLD, 18));

        crrHead = new JLabel("2. Karl Pearson Correlation");
        crrHead.setBounds(200, 210, 300, 50);
        crrHead.setFont(new Font("Serif", Font.BOLD, 24));

        crrDescription = new JLabel("To find out the relationship between two variables");
        crrDescription.setBounds(120, 255, 500, 50);
        crrDescription.setFont(new Font("Serif", Font.BOLD, 22));
        
        crrButton = new JButton("Click Here");
        crrButton.setBounds(300, 310, 120, 40);
        crrButton.setFont(new Font("Serif", Font.BOLD, 18));

        regHead = new JLabel("3. Regression");
        regHead.setBounds(280, 380, 150, 50);
        regHead.setFont(new Font("Serif", Font.BOLD, 24));

        regDescription = new JLabel("To predict a line or an equation");
        regDescription.setBounds(200, 420, 500, 50);
        regDescription.setFont(new Font("Serif", Font.BOLD, 22));

        regButton = new JButton("Click Here");
        regButton.setBounds(300, 480, 120, 40);
        regButton.setFont(new Font("Serif", Font.BOLD, 18));
        
        details = new JButton("Project By:");
        details.setBounds(50, 560, 140, 40);
        details.setFont(new Font("Serif", Font.BOLD, 20));
        
        santhosh = new JLabel();
        santhosh.setBounds(100, 600, 300, 50);
        santhosh.setFont(new Font("Serif", Font.BOLD, 20));
        
        karthik1 = new JLabel();
        karthik1.setBounds(100, 630, 300, 50);
        karthik1.setFont(new Font("Serif", Font.BOLD, 20));
        
        karthik2 = new JLabel();
        karthik2.setBounds(100, 660, 300, 50);
        karthik2.setFont(new Font("Serif", Font.BOLD, 20));     
    }

    public void addComponentsToFrame() 
    {
        frame.add(head);
        frame.add(crrTypes);
        frame.add(crrHead);
        frame.add(crrDescription);
        frame.add(regHead);
        frame.add(regDescription);
        frame.add(crrTypesButton);
        frame.add(crrButton);
        frame.add(regButton);
        frame.add(details);
        frame.add(karthik1);
        frame.add(karthik2);
        frame.add(santhosh);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        //frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setBounds(500, 150, 750, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addActionEvent()
    {
        crrTypesButton.addActionListener(this);
        crrButton.addActionListener(this);
        regButton.addActionListener(this);
        details.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == crrTypesButton) 
        {
            CorrelationTypes t = new CorrelationTypes();
        }

        if (e.getSource() == crrButton)
        {
            Correlation c = new Correlation();
        }

        if (e.getSource() == regButton)
        {
            Regression r = new Regression();
        }
        
        if(e.getSource() == details)
        {
            karthik1.setText("Karthik M");
            karthik2.setText("Karthik Bhat");
            santhosh.setText("Santhosh Kumar");
        }
    }

    public static void main(String[] args) throws Exception
    {
        new Main();
    }

}
