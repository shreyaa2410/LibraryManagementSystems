package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Loading extends JFrame implements Runnable
{
	private JPanel contentpane;
	private JProgressBar progressbar;
	int s;
	Connection Conn;
	Thread th;
public Loading()
{
	super("Loading");
	th=new Thread((Runnable)this);
	setBounds(600, 300, 600, 400);
	contentpane= new JPanel();
	setContentPane(contentpane);
    contentpane.setLayout(null);
	
	JPanel frame= new JPanel();
	frame.setLayout(null);
	frame.setBackground(Color.gray);
	frame.setBounds(0, 0, 590, 390);
	contentpane.add(frame);
	
	JLabel libraryManagement= new JLabel("Smart Library v5.1");
	libraryManagement.setBackground(new Color(72, 209, 204));
	libraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
	libraryManagement.setForeground(new Color(72, 209, 204));
	libraryManagement.setBounds(130, 46, 500, 35);
	frame.add(libraryManagement);
	
	progressbar= new JProgressBar();
	progressbar.setFont(new Font("Tahoma", Font.BOLD, 12));
	progressbar.setBounds(130, 135, 300, 25);
	progressbar.setStringPainted(true);
	frame.add(progressbar);
	
	JLabel label2 = new JLabel("Please Wait....");
	label2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
	label2.setForeground(new Color(160, 82, 45));
	label2.setBounds(200, 165, 150, 20);
    frame.add(label2);
	
    setUploading();
	
}

public static void main(String args[])
{
	new Loading().setVisible(true);
}

public void setUploading()
{
	setVisible(false);
	th.start();
}
public void run()
{
	try {
        for (int i = 0; i < 200; i++) {
            s = s + 1;
            int m = progressbar.getMaximum();
            int v = progressbar.getValue();
            if (v < m) {
                progressbar.setValue(progressbar.getValue() + 1);
            } else {
                i = 201;
                setVisible(false);
                new Home().setVisible(true);
                
            }
            Thread.sleep(50);
        }
    } catch (Exception e) {
e.printStackTrace();
    }
}
}
