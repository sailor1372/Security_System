import com.pi4j.wiringpi.Serial;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;

public class Mainclass{
	
	public static void main (String[] args) throws IOException,InterruptedException{
		MP3Player player1 = new MP3Player(new File("./Sounds/Mute.mp3"));  //音のBufferingを防止
        player1.play();
		Alrm s1 = new Alrm();
		//int serialPort = Serial.serialOpen(Serial.DEFAULT_COM_PORT, 9600);
		int serialPort = Serial.serialOpen("/dev/ttyACM0", 57600);
		if(serialPort == -1){
			System.out.println("Serial Port Failed");
			return;
		}else{
			System.out.println("Raspberry Pi -> Arduino : Serial Port Good");
			System.out.println("\n");
			System.out.println("\n");
			
		}/*
		Serial.serialPuts(serialPort,"Access");
		while(true){
			if(Serial.serialDataAvail(serialPort) > 0 ){
				char inChar = (char)Serial.serialGetchar(serialPort);
				System.out.println(inChar);
			}
		}
		//Serial.serialClose(serialPort);
	}
}

*/
		Serial.serialPuts(serialPort,"Access");
				while(true){
					if((char)Serial.serialGetchar(serialPort) == 'a' ){
						//char inChar = (char)Serial.serialGetchar(serialPort);
						System.out.println("=====異常感知=====");
						s1.Start();		
						break;
					}
				}
				//Serial.serialClose(serialPort);
			}
		}
