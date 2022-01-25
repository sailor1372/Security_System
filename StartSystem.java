import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StartSystem extends JFrame{ 
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss");		
	boolean a = false; //一般勤務者の情報の確認
	boolean m = false; //一般勤務者の情報の確認
	Pass pass = new Pass("atw","0000");	 
	Pass master = new Pass("mtr","11");
	
	StartSystem(){		
		Font font = new Font("",Font.BOLD,16);
		
		JLabel date = new JLabel("起動時間　:　" + sdf.format(cal.getTime()));
		date.setBounds(200,250,290,20);				 
		
		JLabel top = new JLabel("Input System Key,Pass");
		top.setBounds(20,15, 200,20);		
		
		JLabel lb1 = new JLabel();
		lb1.setBounds(20,210, 150,50);
		
		JLabel lb2=new JLabel("Access Key :");
		lb2.setBounds(20,60, 150,30);
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(130,60, 120,30);
		
		JLabel lb3=new JLabel("Password :");
		lb3.setBounds(20,110, 150,30);
		
		//JPasswordField pw1 = new JPasswordField();
		JTextField pw1 = new JTextField();
		pw1.setBounds(130,110,120,30);
	
		JButton bt1 = new JButton("Access");
		bt1.setBounds(80,170, 150,30);
		
		bt1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				/*String data = "Access Pass :  " + tf1.getText();
				data += ", Password: "
						+ new String(pw1.getPassword());
				lb1.setText(data);
				*/ 
				//Pass pass = new Pass(tf1.getText(),pw1.getPassword());
				
				if(a = pass.Start_certify(tf1.getText(),pw1.getText())) {
					lb1.setText("認証成功"); 
					lb1.setFont(font);
					dispose();
					//new PassLogin(); 
				}else {
					lb1.setText("認証失敗");
					lb1.setFont(font);
				}	
				if(m = master.Master_certify(tf1.getText(),pw1.getText())) {
					lb1.setText("認証成功"); 
					lb1.setFont(font);
					dispose();
					//new PassLogin(); 
				}else {
					lb1.setText("認証失敗");
					lb1.setFont(font);
				}	
			}
			
});		add(lb1);add(pw1);
		add(lb2);add(tf1);add(top);
		add(lb3);add(bt1);add(date);
		setTitle("ECC SecuritySystem Login");
		setSize(450,320);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
