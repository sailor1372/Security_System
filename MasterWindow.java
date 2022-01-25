import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.*;


public class MasterWindow extends JFrame{	
	boolean m = false;
	
	public MasterWindow() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		Font font = new Font("",Font.BOLD,16);
		Font font2 = new Font("",Font.BOLD,20);
		Font ea1 = new Font("",Font.BOLD,25);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel wel = new JLabel("Welcome Security Master");
		wel.setBounds(120,25,450,40);			
		wel.setFont(ea1);
		
		JLabel text1 = new JLabel("マスターモード接続完了");
		text1.setBounds(180,70,400,30);
		text1.setForeground(Color.RED);
		text1.setFont(font2);
		
		JLabel text2 = new JLabel("(注意：60秒後自動実行)");
		text2.setBounds(205,100,400,30);
		text2.setForeground(Color.RED);
		text2.setFont(font);
		
		JButton bt1 = new JButton("起動");
		bt1.setBounds(250,150,100,30);
		bt1.setFont(font2);
		
		add(wel);add(text1);add(text2);add(bt1);
		
		setBounds(250,150,100,30);
		setTitle("Master Login");
		setSize(600,260);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		//ボタンを押すと新たなwindowが表示され、そのwindowに表示されている時間以内（実行前にに出す為に時に必要な余裕時間)
		bt1.addActionListener(new ActionListener() {            
			public void actionPerformed(ActionEvent e) {
				System.out.println("監視モード起動");		
				dispose();
				new StartMaster(); 	
			}		
			
		});	
	}
	public static void main(String[] args) {
		new MasterWindow();
	}
    
}
