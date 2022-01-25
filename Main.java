import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;

public class Main extends Thread{
    public static void main(String[] args) throws IOException, InterruptedException {
	MP3Player player1 = new MP3Player(new File("./Sounds/Mute.mp3"));  //音のBufferingを防止
        player1.play();
	
	StartSystem si = new StartSystem();
	DigitalClock dc = new DigitalClock();  
	
	//マスターと一般勤務者の情報を区別
	while(!si.a || !si.m){ 
	    System.out.println("");
	    if(si.m){
		System.out.println("マスターログイン");
		//new Security();
		dc.dispose();
		new MasterWindow();
		break;
	    }
	    if(si.a) {
		PassLogin pl = new PassLogin();	
		//状況別分岐点
		for(int i = 15; i >= 0; i--) { 
		    System.out.println(i + "秒");
		    try{
			Thread.sleep(1000);
		    }catch(InterruptedException e){
			e.printStackTrace();
		    }
		    if(i == 30) {
			System.out.println("警告　：　３０秒以内に入力しなさい。");
		    }
		    //非常状況発令 
		    else if(i == 0) {
			si.dispose(); 
			dc.dispose();
			pl.dispose();
			Alrm ai = new Alrm();
			ai.Start();
		    }       
		    if(pl.a) {
			System.out.println("Access");
			new Home();
			break;
		    }		    
		}
	    }
	} 
    } 
}
