/*
 * @author Santhosh Kumar
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Regression implements ActionListener 
{
    JFrame regFrame;
    JLabel regHead;
    JLabel regDescription;
    JLabel regFormula1;
    JLabel regFormula2;
    JLabel regFormula3;
    JLabel labelX;
    JLabel labelY;
    JLabel labelRadio; 
    JLabel showResult;
    JTextField inputX;
    JTextField inputY;
    JRadioButton radioX;
    JRadioButton radioY;
    JButton regSubmit;
    JButton regReset;
 
    Regression() 
    {
        setComponents();
        addComponentsToFrame();
        addActionEvent();
    }
 
    public void setComponents()
    {
        regFrame= new JFrame("STATISTICS");
        
        regHead = new JLabel("REGRESSSION");
        regHead.setBounds(300, 10, 300, 50);
        regHead.setFont(new Font("Serif", Font.BOLD, 25));
        
        regDescription = new JLabel("Regresssion is used to estimate/ predict a line or an equation for given set of values.");
        regDescription.setBounds(40, 65, 800, 50);
        regDescription.setFont(new Font("Serif", Font.BOLD, 22));  
        
        regFormula1 = new JLabel("y = a + bx");
        regFormula1.setBounds(320, 55, 500, 150);
        regFormula1.setFont(new Font("Serif", Font.BOLD, 21)); 
        
        regFormula2 = new JLabel("∑yi = na + b ∑xi     " + "    ∑xiyi = a ∑xi^2 + b ∑xi");
        regFormula2.setBounds(200, 100, 500, 150);
        regFormula2.setFont(new Font("Serif", Font.BOLD, 20)); 
         
        regFormula3 = new JLabel("r =(sqrt (Mxy * Myx))");
        regFormula3.setBounds(300, 150, 500, 150);
        regFormula3.setFont(new Font("Serif", Font.BOLD, 20)); 
        
        labelX= new JLabel("Enter the values of  X");
        labelX.setBounds(180, 280, 200, 30);
        labelX.setFont(new Font("Serif", Font.BOLD, 20)); 
         
        inputX = new JTextField();
        inputX.setBounds(380, 280, 200, 30);
        
        labelY= new JLabel("Enter the values of  Y");
        labelY.setBounds(180, 340, 200, 30);
        labelY.setFont(new Font("Serif", Font.BOLD, 20));
        
        inputY = new JTextField();
        inputY.setBounds(380, 340, 200, 30);
        
        labelRadio= new JLabel("Select any one");
        labelRadio.setBounds(200, 390, 200, 30);
        labelRadio.setFont(new Font("Serif", Font.BOLD, 20));
        
        radioX = new JRadioButton ("X on Y");
        radioX.setBounds(380, 390, 100, 30);
        radioX.setFont(new Font("Serif", Font.BOLD, 20));
        
        radioY = new JRadioButton ("Y on X");
        radioY.setBounds(490, 390, 150, 30); 
        radioY.setFont(new Font("Serif", Font.BOLD, 20));
        
        regSubmit = new JButton("SUBMIT"); 
        regSubmit.setBounds(250, 450, 100, 40);
        regSubmit.setFont(new Font("Serif", Font.BOLD, 17));
        
        regReset = new JButton("RESET");
        regReset.setBounds(400, 450, 100, 40);
        regReset.setFont(new Font("Serif", Font.BOLD, 17));
        
        showResult = new JLabel();
        showResult.setBounds(240, 520, 500, 40);
        showResult.setFont(new Font("Serif", Font.BOLD, 25));
    }
 
    public void addComponentsToFrame() 
    {
        regFrame.add(regHead);
        regFrame.add(regDescription);
        regFrame.add(regFormula1);
        regFrame.add(regFormula2);
        regFrame.add(regFormula3);
        regFrame.add(labelX);
        regFrame.add(labelY);
        regFrame.add(inputX);
        regFrame.add(inputY);
        regFrame.add(labelRadio);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioX);
        bg.add(radioY);
        regFrame.add(radioX);
        regFrame.add(radioY); 
        regFrame.add(regSubmit);
        regFrame.add(regReset);
        regFrame.add(showResult);
        
        regFrame.setLayout(null);
        regFrame.setVisible(true);
        regFrame.setResizable(false);
        regFrame.setBounds(650, 150, 850, 700);
        regFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
 
    public void addActionEvent()
    {
        regSubmit.addActionListener(this);
        regReset.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == regSubmit)
        {
            String x_values= inputX.getText(); 
            String y_values= inputY.getText();
            
            if(x_values.isEmpty() || y_values.isEmpty())
            {
                JOptionPane.showMessageDialog(regSubmit, "Please enter values of X and Y");
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
                    if(radioX.isSelected())
                    {
                        int n = X.length;
                        
                        float Mxy= regressionMxyFinder(X, Y, n);        
                        String m= Float.toString(Mxy);
                        
                        float reg= regressionXEquation(X, Y, Mxy, n);
                        String r= Float.toString(reg);
                        
                        showResult.setText("X = "+ m +" Y + " + r);
                    }
                
                    else if(radioY.isSelected())
                    {
                        int n = X.length;
                        
                        float Myx= regressionMyxFinder(X, Y, n);        
                        String m= Float.toString(Myx);
                        
                        float reg= regressionYEquation(X, Y, Myx, n);
                        String r= Float.toString(reg);
                        
                        showResult.setText("Y = "+ m +" X + " + r);
                    }
                    
                    else
                    {
                        JOptionPane.showMessageDialog(regSubmit, "No button selected");
                    }
                }
            
                else
                {
                    JOptionPane.showMessageDialog(regSubmit, "Please enter equal values of X and Y");
                }
            }
        }
                          
        if(e.getSource() == regReset)
        {
            inputX.setText("");
            inputY.setText("");
            showResult.setText("");
        }        
    }
    
    //X on Y
    
    static float regressionMxyFinder(int X[], int Y[], int n)
    {
        int sum_X = 0, sum_Y = 0, sum_XY = 0; 
        int squareSum_Y = 0; 
        
        for (int i = 0; i < n; i++) 
        {
           sum_X = sum_X + X[i];                // sum of elements of array X.
           sum_Y = sum_Y + Y[i];               // sum of elements of array Y. 
           sum_XY = sum_XY + X[i] * Y[i];                   // sum of X[i] * Y[i]. 
           squareSum_Y = squareSum_Y + Y[i] * Y[i]; 
        }
        
        float m_xy = (float)(n* sum_XY- sum_X* sum_Y)/ (float) (n* squareSum_Y- sum_Y* sum_Y); 		
        return m_xy; 
    } 
    
    static float regressionXEquation(int X[], int Y[], float Mxy, int n)
    {
        int sum_X = 0, sum_Y = 0;
        
        for (int i = 0; i < n; i++) 
        {
           sum_X = sum_X + X[i];               
           sum_Y = sum_Y + Y[i];               
        }
        float x_Bar = (float) sum_X / n; 
        float y_Bar = (float) sum_Y / n;
        
        y_Bar = Mxy * (- y_Bar); 
        float x = y_Bar + x_Bar;
        return x; 
    }
    
    
    //Y on X
    
    static float regressionMyxFinder(int X[], int Y[], int n)
    {
        int sum_X = 0, sum_Y = 0, sum_XY = 0; 
        int squareSum_X = 0; 
        
        for (int i = 0; i < n; i++) 
        {
           sum_X = sum_X + X[i];                // sum of elements of array X.
           sum_Y = sum_Y + Y[i];               // sum of elements of array Y. 
           sum_XY = sum_XY + X[i] * Y[i];                   // sum of X[i] * Y[i]. 
           squareSum_X = squareSum_X + X[i] * X[i];
        }
        
        float m_yx = (float)(n* sum_XY- sum_X* sum_Y)/ (float) (n* squareSum_X- sum_X* sum_X); 			
        return m_yx; 
    } 
    
    static float regressionYEquation(int X[], int Y[], float Myx, int n)
    {
        int sum_X = 0, sum_Y = 0; 
        
        for (int i = 0; i < n; i++) 
        {
           sum_X = sum_X + X[i];                
           sum_Y = sum_Y + Y[i];               
        }
        float x_Bar = (float) sum_X / n; 
        float y_Bar = (float) sum_Y / n;
        
        x_Bar = Myx + (- x_Bar);
        float y = x_Bar + y_Bar;
        return y; 
    }
 
    public static void main(String[] args) throws Exception
    {
        new Regression();
    }
    
}