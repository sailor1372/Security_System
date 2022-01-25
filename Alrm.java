
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;

public class Alrm extends JFrame{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 H:mm:ss");
	Calendar cal = Calendar.getInstance();
	Date date = cal.getTime();
	
         	
	public void Start()  throws IOException,InterruptedException{		
				    
		Font font = new Font("",Font.BOLD,16);
		Font font2 = new Font("",Font.BOLD,20);
		Font ea1 = new Font("",Font.BOLD,25);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
		JLabel eme = new JLabel("Emergency System Operation");
		eme.setBounds(100,25,450,40);			
		eme.setFont(ea1);
        
		JLabel re = new JLabel("実際状況");
		re.setBounds(260,80,80,20);		
		re.setForeground(Color.RED);
		re.setFont(font2);
        
		JLabel alert1 = new JLabel("勤務者は状況");
		alert1.setBounds(140,110,150,20);			
		alert1.setFont(font2);		
		
		JLabel e1 = new JLabel("E1");
		e1.setBounds(275,109,40,20);		
		e1.setForeground(Color.RED);
		e1.setFont(ea1);		
				
		JLabel alert2 = new JLabel("に対応すること");
		alert2.setBounds(320,110,150,20);			
		alert2.setFont(font2);
        
		JLabel date = new JLabel(sdf.format(cal.getTime()));
		date.setBounds(280,190,500,20);			
		date.setFont(font2);
		
		
		add(eme);add(alert1);add(re);
		add(e1);add(alert2);add(date);
		setTitle("Alert");
		setSize(600,260);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(sdf.format(cal.getTime()));
		
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new MyThread();
		
		t1.start();
		t2.start();
		
		try{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e){
		}
	}
		
		
		/* 画面レイアウトの追加
		 * 赤ランプを点滅
		 * ドアを閉める
		 * サイレンを鳴らす
		 */
		
		
	
}
