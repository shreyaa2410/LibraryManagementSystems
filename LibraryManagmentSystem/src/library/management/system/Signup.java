package library.management.system;

 import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
 
 public class Signup extends JFrame implements ActionListener
 {
	 private JPanel panel;
	 private JTextField textfield;
	 private JTextField textfield_1;
	 private JTextField textfield_2;
	 private JTextField textfield_3;
	 private JButton b1,b2;
	 private JComboBox comboBox;
	 
	 public static void main(String args[])
	 {
		 new Signup().setVisible(true);
	 }
	 
	 public Signup()
	 {
		 setBounds(600, 250, 606, 406);
		 JPanel panel =new JPanel();
		 panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setContentPane(panel);
		 panel.setBackground(Color.WHITE);
		 panel.setLayout(null);
		 
		 JLabel username= new JLabel("Username: ");
		 username.setBounds(99, 86, 92, 26);
		 username.setForeground(Color.DARK_GRAY);
		 username.setFont(new Font("Tahoma", Font.BOLD, 14));
		 panel.add(username);
		 
		 JLabel name= new JLabel("Name: ");
		 name.setBounds(99,123, 92, 26);
		 name.setForeground(Color.DARK_GRAY);
		 name.setFont(new Font("Tahoma", Font.BOLD, 14));
		 panel.add(name);
		 
		 JLabel password= new JLabel("Password: ");
		 password.setBounds(99,160, 92, 26);
		 password.setForeground(Color.DARK_GRAY);
		 password.setFont(new Font("Tahoma", Font.BOLD, 14));
		 panel.add(password);
		 
		 JLabel securityQues= new JLabel("Security Questions: ");
		 securityQues.setBounds(99, 197, 140, 26);
		 securityQues.setForeground(Color.DARK_GRAY);
		 securityQues.setFont(new Font("Tahoma", Font.BOLD, 14));
		 panel.add(securityQues);
		 
		 JLabel answer= new JLabel("Answer: ");
		 answer.setBounds(99,234, 92, 26);
		 answer.setForeground(Color.DARK_GRAY);
		 answer.setFont(new Font("Tahoma", Font.BOLD, 14));
		 panel.add(answer);
		 
		 comboBox= new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {
				 "Your NickName?","Your Childhood Name?","Your SuperHero?",
				 "Your Lucky Number?","Your Favourite Food?" }));
		 comboBox.setBounds(265, 202, 148, 20);
		 panel.add(comboBox);
		 
		 
	    textfield = new JTextField();
		textfield.setBounds(265, 91, 148, 20);
		panel.add(textfield);
		textfield.setColumns(10);

		textfield_1 = new JTextField();
		textfield_1.setColumns(10);
		textfield_1.setBounds(265, 128, 148, 20);
		panel.add(textfield_1);

	    textfield_2 = new JTextField();
		textfield_2.setColumns(10);
		textfield_2.setBounds(265, 165, 148, 20);
		panel.add(textfield_2);

		textfield_3 = new JTextField();
		textfield_3.setColumns(10);
		textfield_3.setBounds(265, 239, 148, 20);
		panel.add(textfield_3);

		b1 = new JButton("Create");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 13));
		b1.setBounds(140, 289, 100, 30);
	        b1.setBackground(Color.BLACK);
	        b1.setForeground(Color.WHITE);
		panel.add(b1);

		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 13));
		b2.setBounds(300, 289, 100, 30);
		b2.setBackground(Color.BLACK);
	        b2.setForeground(Color.WHITE);
		panel.add(b2);
			
			
		 JPanel div = new JPanel();
		 div.setForeground(new Color(34, 139, 34));
		 div.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
		 div.setBounds(31, 46, 476, 296);
		 div.setBackground(Color.WHITE);
	     panel.add(div);
	 }
	 
	 public void actionPerformed(ActionEvent ae)
	 {
		 try
		 {
			 Conn con= new Conn();
			 if(ae.getSource()==b1)
			 {
				 String sql= "insert into account (username,name,password,sec_q,sec_ans)values(?,?,?,?,?)";
				 PreparedStatement st = con.c.prepareStatement(sql);
				 st.setString(1, textfield.getText());
				 st.setString(2, textfield_1.getText());
				 st.setString(3, textfield_2.getText());
				 st.setString(4,(String) comboBox.getSelectedItem() );
				 st.setString(5, textfield_3.getText());
				 
				 
				 int i = st.executeUpdate();
				 if (i > 0){
	                    	JOptionPane.showMessageDialog(null, "successfully Created");
			                }

	                textfield.setText("");
	                textfield_1.setText("");
					textfield_2.setText("");
					textfield_3.setText("");
			 }
			 if(ae.getSource()==b2)
			 {
				 this.setVisible(false);
				 new Login_user().setVisible(true);
				 
			 }
		 }
		 catch(Exception e){
	            e.printStackTrace();
	        }
	 }
	 
 }