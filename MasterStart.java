import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MasterStart extends JFrame {
	private JLabel label;

	class MyThread extends Thread {
  		public void run() {
		
	  	    for (int i = 60; i >= 0; i--) {
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
				 	e.printStackTrace();
				}
			label.setText(i + "•b");
			if(i <= 0){
				label.setText("“®ìŠJŽn");
				label.setBounds(320,150,150,30); 
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
				 	e.printStackTrace();
				}
				label.setText("");
			}			
			}
	  	}
}

	public CountDownTest() {
		Font font = new Font("",Font.BOLD,30);
		Font font2 = new Font("",Font.BOLD,40);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel text1 = new JLabel("Security System “®ì’†");
		text1.setBounds(85,30,450,90);
		text1.setForeground(Color.RED);
		text1.setFont(font2);
		add(text1);
		
		JLabel panel = new JLabel();
		label = new JLabel("");
		
		label.setFont(font);
		label.setBounds(270,120,150,30); 
		panel.add(label);
		add(panel);
		
		(new MyThread()).start();
		setVisible(true);
		setTitle("");
		setSize(600,260);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
 		new CountDownTest();
	 }
}
