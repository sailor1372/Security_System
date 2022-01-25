import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;


public class Login2  {
	
    public void secondLogin()throws IOException, InterruptedException{
    MP3Player player1 = new MP3Player(new File("./Sounds/Mute.mp3"));  //音のBufferingを防止
    player1.play();
	        
	while(true){ 
	    PassLogin pl = new PassLogin();	
	    pl.a = false;   //再接続する時の判定の初期化
	    //状況別分岐点
	    for(int i = 25; i >= 0; i--) { 
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

