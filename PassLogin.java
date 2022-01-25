
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PassLogin extends JFrame{
	ImageIcon i = new ImageIcon("./Image/sr71.jpg");
	Image im=i.getImage();

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss");	
	static boolean a = false; 
	Pass passA = new Pass("at1","bt1");	
    
    public PassLogin(){
    	Font font = new Font("",Font.BOLD,20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageP panel = new ImageP ();
        panel.setLayout(new FlowLayout());
        
        JLabel date = new JLabel("起動時間　:　" + sdf.format(cal.getTime()));
	date.setBounds(800,680,500,20);	
	date.setForeground(Color.white);
	date.setFont(font);
	
	/*
	JLabel top = new JLabel("Input Key A , key B");
	top.setBounds(500,260, 200,30);		
	top.setForeground(Color.white);
	top.setFont(font);
	*/
	JLabel lb1 = new JLabel();
	lb1.setBounds(550,430, 90,30);
	lb1.setForeground(Color.white);
	lb1.setFont(font);
	
	
	JLabel lb2=new JLabel("Access Key A :");
	lb2.setBounds(440,330, 200,25);
	lb2.setForeground(Color.white);
	lb2.setFont(font);
	
	JTextField tf1 = new JTextField();
	tf1.setBounds(630,330, 120,30);
	tf1.setFont(font);
	
	JLabel lb3=new JLabel("Access Key B :");
	lb3.setBounds(440,380, 200,25);
	lb3.setForeground(Color.white);
	lb3.setFont(font);
	
	JTextField pw1 = new JTextField();
	pw1.setBounds(630,380,120,30);
	pw1.setFont(font);

	JButton bt1 = new JButton("Access");
	bt1.setBounds(530,460, 120,40);
	bt1.setForeground(Color.BLACK);
	bt1.setFont(font);
	
	bt1.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) {		
			if(a = passA.Start_certify(tf1.getText(),pw1.getText())) {
				lb1.setText("認証成功"); 
				dispose();
				
			}else {
				lb1.setText("認証失敗");
			}			
		}
	});		
	
	add(lb1);add(pw1);add(date);
	add(lb2);add(tf1);//add(top);
	add(lb3);add(bt1);		
				
        this.add(panel);
        this.setSize(1280,768);
        this.setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Login");		
	setResizable(false);
	setLayout(null);
	setVisible(true);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class ImageP extends JPanel{             
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }
}
