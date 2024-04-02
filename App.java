// Akshita Agarwal: E23CSEU1875
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class App extends WindowAdapter implements ActionListener {

    JFrame jf;
    JButton[] jb = new JButton[16];
    String caption[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/" };
    JPanel jp;
    JLabel jl;
    int flag;
    String op1, op2, op;
    String digits = "0123456789";
    String operators = "+/*-";

    App() {
        jf = new JFrame("Simple Calculator");
        jf.addWindowListener(this);
        jl = new JLabel("0");
        jl.setFont(new Font("Arial", 1, 18));
        jp = new JPanel();
        jp.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
            jb[i] = new JButton(caption[i]);
            jb[i].addActionListener(this);
            jp.add(jb[i]);
        }
        jf.add(jl, BorderLayout.NORTH);
        jf.add(jp);
        jf.setVisible(true);
        jf.setSize(400, 400);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String text = btn.getText();
        if (digits.contains(text)) {
            if (flag == 0) {
                jl.setText(text);
                flag = 1;
            } else {
                jl.setText(jl.getText() + text);
            }
        }
        if (operators.contains(text)) {
            op1 = jl.getText();
            op = text;
            flag = 0; // so that next new number can be taken
        }
        if (text.equals("=")) {
            op2 = jl.getText();
            calc();
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void windowClosing(WindowEvent e) {
        jf.dispose();
    }

    void calc() {
        float x, y, z;
        x = Float.parseFloat(op1); // operand 1
        y = Float.parseFloat(op2); // operand 1
        //performing operations
        if (op.equals("+")) {
            z = x + y;
        } else if (op.equals("-")) {
            z = x - y;
        } else if (op.equals("*")) {
            z = x * y;
        } else
            z = x / y;
        jl.setText("" + (int)z);
    }

}

/*
 * import java.awt.*;
 * import java.awt.event.*;
 * class MyEvents extends WindowAdapter implements ActionListener
 * {
 * String op1,op2,op;
 * int flag;
 * Frame f;
 * Button b[]=new Button[16];
 * String
 * caption[]={"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
 * Label l;
 * Panel p;
 * String digits="0123456789";
 * String operators="+-/*";
 * MyEvents()
 * {
 * f=new Frame();
 * f.addWindowListener(this);
 * l=new Label("0");
 * l.setFont(new Font("Arial",1,18));
 * p=new Panel();
 * p.setLayout(new GridLayout(4,4));
 * for(int i=0;i<16;i++)
 * {
 * b[i]=new Button(caption[i]);
 * b[i].setFont(new Font("Arial",1,18));
 * b[i].addActionListener(this);
 * p.add(b[i]);
 * }
 * f.add(l,BorderLayout.NORTH);
 * f.add(p);
 * f.setVisible(true);
 * f.setSize(300,300);
 * }
 * 
 * public static void main(String ar[])
 * {
 * MyEvents e=new MyEvents();
 * }
 * 
 * public void actionPerformed(ActionEvent e) // e.getSource(), e.getX(),
 * e.getY()
 * {
 * Button bt=(Button)e.getSource();
 * String text=bt.getLabel();
 * if(digits.contains(text))
 * {
 * if(flag==0)
 * {
 * l.setText(text);
 * flag=1;
 * }
 * else
 * {
 * l.setText(l.getText()+text);
 * }
 * }
 * if(operators.contains(text))
 * {
 * op1=l.getText();
 * op=text;
 * flag=0;
 * }
 * if(text.equals("="))
 * {
 * op2=l.getText();
 * calc();
 * }
 * }
 * 
 * public void windowClosing(WindowEvent e)
 * {
 * f.dispose();
 * }
 * 
 * void calc()
 * {
 * float x,y,z;
 * x=Float.parseFloat(op1);
 * y=Float.parseFloat(op2);
 * if(op.equals("+"))
 * z=x+y;
 * else if(op.equals("-"))
 * z=x-y;
 * else if(op.equals("*"))
 * z=x*y;
 * else
 * z=x/y;
 * l.setText(""+z);
 * }
 * 
 * }
 */
