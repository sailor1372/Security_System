import java.awt.Font;
import java.awt.Color;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pi4j.wiringpi.Serial;
import java.io.IOException;

public class StartMaster extends JFrame {	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 H:mm:ss");
	Calendar cal = Calendar.getInstance();
	Date date = cal.getTime();
	Alrm2 s1 = new Alrm2();
	int serialPort = Serial.serialOpen("/dev/ttyACM0", 57600);
		
	private JLabel label;
	class MyThread extends Thread {
  		public void run(){		
	  	    for (int i = 10; i >= 0; i--) {
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
				 	e.printStackTrace();
				}
				label.setText(i + "秒");
				if(i <= 0){
					label.setText("動作開始");
					label.setBounds(270,120,150,30); 
					try {
						Thread.sleep(1000);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					label.setText("");
						try{
							Ultrasonic();
						}catch(IOException | InterruptedException e1){  //メソッドを呼び出し時の例外
							e1.printStackTrace();
						}				
						
				}			
			}
	  	}
	}
	
	public StartMaster() {
		setResizable(false);
		setSize(600,260);
		setLocationRelativeTo(null);
		
		Font dateFont = new Font("",Font.BOLD,18);
		Font font = new Font("",Font.BOLD,25);
		Font font2 = new Font("",Font.BOLD,35);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel text1 = new JLabel("Security System 動作中");
		text1.setBounds(80,20,580,90);
		text1.setForeground(Color.RED);
		text1.setFont(font2);
		add(text1);
		
		JLabel panel = new JLabel();
		label = new JLabel("");
		
		JLabel date = new JLabel(sdf.format(cal.getTime()));
		date.setBounds(320,200,500,20);			
		date.setFont(dateFont);
		add(date);
		
		label.setFont(font);
		label.setBounds(270,120,150,30); 
		panel.add(label);
		add(panel);
		
		//new MyThread().start();
		setVisible(true);
		setTitle("");
		
		
		
		new MyThread().start();
	}
	//Aruduinoからシリアル通信でセンサーのデータを取得　
	//異常が感知されるとAruduinoからchar型変数:'a'を受ける。
	void Ultrasonic() throws IOException,InterruptedException{		
		while(true){		
			if((char)Serial.serialGetchar(serialPort) == 'a' ){
				//char inChar = (char)Serial.serialGetchar(serialPort);
				System.out.println("\n\n==========異常感知==========");
				s1.Start();
				break;		
			}else if((char)Serial.serialGetchar(serialPort) == 'd' ){
				System.out.println("\n\n===========OPEN===========");
				System.exit(0);	
				break;
			}		
		}
	}
		

	public static void main(String[] args) throws IOException,InterruptedException {
 		//new StartMaster();
 		StartMaster st = new StartMaster();
	 }
}
