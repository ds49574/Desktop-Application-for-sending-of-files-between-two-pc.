import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class send extends JFrame
{
JPanel jp;
JLabel l1,l2,l3;
JTextField ip,f;
JButton send1;
public send()
{
super("SENDING OF FILE");
setSize(400,400);
setResizable(false);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
jp=new JPanel();
jp.setLayout(null);
send1=new JButton("SEND");
l1=new JLabel("IP ADDRESS");
l2=new JLabel("File Name");
l3=new JLabel();
ip=new JTextField();
f=new JTextField();
l1.setBounds(50,50,100,50);
l2.setBounds(50,130,100,50);
ip.setBounds(200,50,100,50);
f.setBounds(200,130,100,50);
send1.setBounds(150,240,100,50);
l3.setBounds(150,320,100,50);
jp.add(l1);
jp.add(l2);
jp.add(ip);
jp.add(f);
jp.add(send1);
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

send1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
String s1=ip.getText();
String s2=f.getText();
ip.setText("");
f.setText("");
ip.requestFocus();
try{
  Socket sock = new Socket("localhost", 1982);
    byte[] mybytearray = new byte[10000];
    InputStream is = sock.getInputStream();
    FileOutputStream fos = new FileOutputStream("image.jpg");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    int bytesRead = is.read(mybytearray, 0, mybytearray.length);
    bos.write(mybytearray, 0, bytesRead);
    bos.flush();
    bos.close();
    sock.close();
l3.setText("File Send Successfully");
}
catch(Exception e)
{System.out.println(e);}
}});

}
}


