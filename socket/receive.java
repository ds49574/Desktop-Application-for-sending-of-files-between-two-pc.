import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class receive extends JFrame
{
JPanel jp;
JButton receive1;
JLabel l;
public receive()
{
super("RECEIVING OF FILE");
setSize(400,400);
setResizable(false);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
jp=new JPanel();
jp.setLayout(null);
receive1=new JButton("RECEIVE");
l=new JLabel();
receive1.setBounds(180,180,100,50);
l.setBounds(180,280,100,50);
jp.add(l);
jp.add(receive1);
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

receive1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try{
  ServerSocket servsock = new ServerSocket(1982);
    File myFile = new File("images.jpg");
    while (true) {
      Socket sock = servsock.accept();
      byte[] mybytearray = new byte[(int) myFile.length()];
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
      bis.read(mybytearray, 0, mybytearray.length);
      OutputStream os = sock.getOutputStream();
      os.write(mybytearray, 0, mybytearray.length);
      os.flush();
      sock.close();
}}
catch(Exception e)
{System.out.println(e);}
}});

}
}


