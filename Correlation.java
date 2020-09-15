/*
 * @author Santhosh Kumar
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Correlation implements ActionListener 
{
    JFrame crrFrame;
    JLabel crrHead;
    JLabel crrDescription;
    JLabel crrFormula;
    JLabel labelX;
    JLabel labelY;
    JLabel showResult;
    JTextField inputX;
    JTextField inputY;
    JButton crrSubmit;
    JButton crrReset;
    
    Correlation() 
    {
        setComponents();
        addComponentsToFrame();
        addActionEvent();
    }
 
    public void setComponents()
    {
        crrFrame= new JFrame("STATISTICS");
        
        crrHead = new JLabel("KARL PEARSON CORRELATION");
        crrHead.setBounds(210, 10, 500, 50);
        crrHead.setFont(new Font("Serif", Font.BOLD, 25));
        
        crrDescription = new JLabel("A Correlation is a study of degree of relationship between two variables/ data.");
        crrDescription.setBounds(55, 66, 800, 50);
        crrDescription.setFont(new Font("Serif", Font.BOLD, 22));  
        
        crrFormula = new JLabel(new ImageIcon("src\\correlation.jpg"));
        crrFormula.setBounds(120, 110, 550, 150);
         
        labelX= new JLabel("Enter the values of  X");
        labelX.setBounds(180, 290, 200, 30);
        labelX.setFont(new Font("Serif", Font.BOLD, 20)); 
         
        inputX = new JTextField();
        inputX.setBounds(400, 290, 200, 30);
        
        labelY= new JLabel("Enter the values of  Y");
        labelY.setBounds(180, 350, 200, 30);
        labelY.setFont(new Font("Serif", Font.BOLD, 20));
        
        inputY = new JTextField();
        inputY.setBounds(400, 350, 200, 30);
        
        crrSubmit = new JButton("SUBMIT"); 
        crrSubmit.setBounds(250, 415, 100, 40);
        crrSubmit.setFont(new Font("Serif", Font.BOLD, 17));
        
        crrReset = new JButton("RESET");
        crrReset.setBounds(400, 415, 100, 40);
        crrReset.setFont(new Font("Serif", Font.BOLD, 17));
        
        showResult = new JLabel();
        showResult.setBounds(270, 490, 500, 40);
        showResult.setFont(new Font("Serif", Font.BOLD, 25));      
    }
 
    public void addComponentsToFrame() 
    {
        crrFrame.add(crrHead);
        crrFrame.add(crrDescription);
        crrFrame.add(crrFormula);
        crrFrame.add(labelX);
        crrFrame.add(labelY);
        crrFrame.add(inputX);
        crrFrame.add(inputY);
        crrFrame.add(crrSubmit);
        crrFrame.add(crrReset);
        crrFrame.add(showResult);
        
        crrFrame.setLayout(null);
        crrFrame.setVisible(true);
        crrFrame.setResizable(false);
        crrFrame.setBounds(650, 150, 850, 700);
        crrFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
 
    public void addActionEvent()
    {
        crrSubmit.addActionListener(this);
        crrReset.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == crrSubmit)
        {  
            String x_values= inputX.getText(); 
            String y_values= inputY.getText();   

            if(x_values.isEmpty() || y_values.isEmpty())
            {
                JOptionPane.showMessageDialog(crrSubmit, "Please enter values of X and Y");
            }
            
            else
            {
                String[] x_stringArray = x_values.split(",");
                int[] X = new int[x_stringArray.length];
                for (int i = 0; i < x_stringArray.length; i++)
                {
                    String numberAsString = x_stringArray[i];
                    X[i] = Integer.parseInt(numberAsString);
                }

                String[] y_stringArray = y_values.split(",");
                int[] Y = new int[y_stringArray.length];
                for (int i = 0; i < y_stringArray.length; i++)
                {
                    String numberAsString = y_stringArray[i];
                    Y[i] = Integer.parseInt(numberAsString);
                }
                
                if(X.length == Y.length)
                {
                    int n = X.length;
                    float r= correlationCoefficient(X, Y, n);        
                    String crr= Float.toString(r);
                    showResult.setText("Correlation = "+crr);
                }
            
                else{
                        JOptionPane.showMessageDialog(crrSubmit, "Please enter equal values of X and Y");
                }
            }
        }
            
        if (e.getSource() == crrReset)
        {
            inputX.setText("");
            inputY.setText("");
            showResult.setText("");
        }   
    }
    
    static float correlationCoefficient(int X[],int Y[], int n)
    {
        int sum_X = 0, sum_Y = 0, sum_XY = 0; 
        int squareSum_X = 0, squareSum_Y = 0; 
        
        for (int i = 0; i < n; i++) 
        {
           sum_X = sum_X + X[i];                // sum of elements of array X.
           sum_Y = sum_Y + Y[i];               // sum of elements of array Y. 
           sum_XY = sum_XY + X[i] * Y[i];                   // sum of X[i] * Y[i]. 
           squareSum_X = squareSum_X + X[i] * X[i];         // sum of square of array elements. 
           squareSum_Y = squareSum_Y + Y[i] * Y[i]; 
        }
        
        float corr = (float)(n* sum_XY- sum_X* sum_Y)/ (float)(Math.sqrt((n* squareSum_X- sum_X* sum_X) * (n* squareSum_Y- sum_Y* sum_Y))); 	
        return corr; 
    } 
 
    public static void main(String[] args) throws Exception
    {
        new Correlation();
    }

}