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
