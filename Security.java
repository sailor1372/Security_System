import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
//import javax.swing.*;


public class Security extends JFrame{	
	
	public Security() {
		
		
		Font font = new Font("",Font.BOLD,16);
		Font font2 = new Font("",Font.BOLD,30);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
				
		JLabel text1 = new JLabel("Security System 起動中");
		text1.setBounds(130,70,400,40);
		text1.setForeground(Color.RED);
		text1.setFont(font2);
		add(text1);
		
		JLabel timerLabel = new JLabel("60");
		timerLabel.setFont(font2);	
		timerLabel.setBounds(320,150,100,30); 
		add(timerLabel);
		
		setBounds(250,150,100,30);
		setTitle("SecuritySystem");
		setSize(600,260);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
			
		int t = 10;  //timer
		while(true){
		   
		    System.out.println(t + "(s)");
		    try {
			Thread.sleep(1000);
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		    t--;
		    timerLabel.setText(t + "(s)");
		    if(t <= 0){
			break;
		    }
		    
		}
		
	}
	
	public static void main(String[]args){
		new Security();
		
	}   
}
