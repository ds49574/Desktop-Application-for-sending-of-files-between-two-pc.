import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sendreceive extends JFrame
{
JPanel jp;
JLabel l1,l2;
JButton send,receive;
public sendreceive()
{
super("FILE-TRANSFER");
setSize(400,400);
setResizable(false);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
jp=new JPanel();
jp.setLayout(null);
send=new JButton("SEND");
receive=new JButton("RECEIVE");
send.setBounds(150,120,100,50);
receive.setBounds(150,210,100,50);
jp.add(send);
jp.add(receive);
add(jp);
setLocationRelativeTo(null);
setVisible(true);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
int output=JOptionPane.showConfirmDialog(null,"Do You Want To Exit");
if(output==JOptionPane.YES_OPTION)
{
 System.exit(1);
}}});
send.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
dispose();
send aa=new send();
}});
receive.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
dispose();
receive bb=new receive();
}});
}
public static void main(String args[])
{
sendreceive h1=new sendreceive();
}

}


