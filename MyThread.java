import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;
import com.pi4j.wiringpi.Serial;

public class MyThread extends Thread {
	int serialPort = Serial.serialOpen("/dev/ttyACM0", 57600);
	char f = (char)Serial.serialGetchar(serialPort);
	public void run(){
		while(true){
			if((char)Serial.serialGetchar(serialPort) == 'd' ){               
                  System.out.println("\n\n==========OPEN==========");
                  Serial.serialClose(serialPort);
                  System.exit(0);	
              }
			try{
				Thread.sleep(300);
			}catch(InterruptedException e){
			}
			
		   
	   }
		
	}
}

