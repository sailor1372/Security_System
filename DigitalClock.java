
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel; 

public class DigitalClock extends JFrame implements Runnable{
	private Thread thread;
	private JLabel label;

	public DigitalClock(){
		super("");
		setLayout(new FlowLayout());
		label = new JLabel();		
		label.setFont(new Font("Serif",Font.PLAIN, 30));

		if(thread == null){
			thread = new Thread(this);
			thread.start();
		} 
		add(label); 
		setBounds(730,270,450,100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new DigitalClock();
	}
	public void run(){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");		
		while(true){
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			/*String now = cal.get(Calendar.YEAR)+"年"+
					(cal.get(Calendar.MONTH)+1)+"月"+
					cal.get(Calendar.DATE)+"日"+
					cal.get(Calendar.HOUR_OF_DAY)+":"+
					cal.get(Calendar.MINUTE)+":"+
					cal.get(Calendar.SECOND)+"";
					*/		
			String formatStr = sdf.format(date); 
			label.setText(sdf.format(date));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace(); 
			}
		}
	}
}
