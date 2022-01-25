import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;

public class Home extends JFrame{ 
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss");		
	int oldMinute = cal.get(Calendar.MINUTE);
	private JLabel label;
	TimeCheck tc = new TimeCheck();
	
	Home()throws IOException,InterruptedException{		
		 MP3Player player1 = new MP3Player(new File("./Sounds/Mute.mp3")); //Bufferingを 防止
         player1.play();
         
		 final int SW1 = 7;   //wiringPi用		 
		   		 
		 final int ON = 0;
		 final int OFF = 1;	
		 
		 //GPIOを初期化
		 Gpio.wiringPiSetup();
		
		 //SW1を入力に設定
		 Gpio.pinMode(SW1, Gpio.INPUT);	  
	
	     int sw1DataOld = OFF;
		 		 
		 
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Font font = new Font("",Font.BOLD,16);
		Font mars = new Font("",Font.BOLD,25);
		
		JLabel date = new JLabel("起動時間　:　" + sdf.format(cal.getTime()));
		date.setBounds(270,238,400,50);	
		date.setFont(font);	
		
				
		JButton time = new JButton("A");
		time.setBounds(530,200,90,30);
		time.setForeground(Color.RED);
		time.setFont(font);
		/*
		JLabel check = new JLabel("●");
		check.setBounds(600,252,20,20);
		check.setFont(mars);
		check.setForeground(Color.GREEN);
		add(check);
			*/
		add(time);add(date);
		setTitle("Home");
		setSize(640,320);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);	
		
		JLabel panel = new JLabel();
		label = new JLabel();		
		label.setText("●");
		label.setFont(mars);
		label.setBounds(600,245,30,30); 
		panel.add(label);
		add(panel);
		
		
		/*ボタンで残りの再ログインの時間を確認ー＞●の色で表示
		  60分以下： GREEN 
		  30分以下： BLUE
		  15分以下： ORANGE
		  5分以下：　RED  				
		*/
		int i = 0;
		int timer = 3600;
		while(true){
			int sw1Data = Gpio.digitalRead(SW1);
			if(sw1Data != sw1DataOld){
				if(sw1Data == ON){
				dispose();
				Alrm ai = new Alrm();
				ai.Start();
				}
			}
			sw1DataOld = sw1Data;		
			/*現在表示時間を利用して使ったタイマー
			Calendar realTime = Calendar.getInstance();
			int realMinute = realTime.get(Calendar.MINUTE);
			System.out.println("oldMinute : " + oldMinute);
			System.out.println("realTime : "+ realMinute);
			System.out.println(tc.Check(oldMinute,realMinute) +" "+ i++);
			int minute = tc.Check(oldMinute,realMinute);
			if(minute > 30 && minute <= 60){
				label.setText("●");
				label.setForeground(Color.GREEN);
				add(label);
			}else if(minute > 15 && minute <= 30){
				//label.setText("●");
				label.setForeground(Color.BLUE);
				
				//add(label);
			}else if(minute > 7 && minute <= 15){
				//label.setText("●");
				label.setForeground(Color.ORANGE);
				
				//add(label);
			}else if(minute >= 2 && minute <= 7){
				//label.setText("●");
				label.setForeground(Color.RED);
				//add(label);
			}else if(minute == 1){
				dispose();
				Login2 l2 = new Login2();	
				l2.secondLogin();
				break;
			}
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}		
			*/	
			System.out.println(timer);
			if(timer > 1800 && timer  <= 3600){
				label.setText("●");
				label.setForeground(Color.GREEN);
				add(label);
			}else if(timer  > 900 && timer <= 1800){
				//label.setText("●");
				label.setForeground(Color.BLUE);
				
				//add(label);
			}else if(timer  > 420 && timer <= 900){
				//label.setText("●");
				label.setForeground(Color.ORANGE);
				
				//add(label);
			}else if(timer  >= 120 && timer <= 420){
				//label.setText("●");
				label.setForeground(Color.RED);
				//add(label);
			}else if(timer  == 60){
				dispose();
				Login2 l2 = new Login2();	
				l2.secondLogin();
				break;
			}
			try{
				Thread.sleep(5);
				timer--;
			}catch(InterruptedException e){
				e.printStackTrace();
			}	
		}
	}
	/*
	public static void main(String[]args)throws IOException,InterruptedException{
		new Home();
	}
	*/
}
