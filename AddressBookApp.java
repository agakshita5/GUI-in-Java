import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddressBookApp extends WindowAdapter implements ActionListener{

    JFrame jf;
    JPanel jp1,jp2;
    JLabel jl1,jl2,jl3;
    JTextField jtf1,jtf2,jtf3;
    JButton jb1,jb2;
    JList<String> jlst;
    DefaultListModel<String> model;

    AddressBookApp(){
        jf=new JFrame("Address Book");
        jl1=new JLabel("Name");
        jl2=new JLabel("Phone No.");
        jl3=new JLabel("Email Address");
        jb1=new JButton("Add Contact");
        jb2=new JButton("Delete Contact");
        jtf1=new JTextField(20);
        jtf2=new JTextField(20);
        jtf3=new JTextField(20);
        model=new DefaultListModel<>();
        jlst=new JList<>(model);
        jf.addWindowListener(this);
        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel();
        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jl2);
        jp1.add(jtf2);
        jp1.add(jl3);
        jp1.add(jtf3);
        jp2.add(jb1);
        jp2.add(new JScrollPane(jlst));
        jp2.add(jb2);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jf.add(jp1,BorderLayout.NORTH);
        jf.add(jp2,BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        AddressBookApp app=new AddressBookApp();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jb1){
            String nm=jtf1.getText();
            String pno=jtf2.getText();
            String email=jtf3.getText();
            String info=String.format("%s : %s | %s",nm,pno,email);
            model.addElement(info);
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
        }else if (e.getSource()==jb2){
            int selIdx=jlst.getSelectedIndex();
            model.remove(selIdx);
        }
    }
    public void windowClosing(WindowEvent e){
        jf.dispose();
    }
}
