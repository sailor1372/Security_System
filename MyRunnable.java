import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;
import com.pi4j.wiringpi.Serial;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;
class MyRunnable implements Runnable {
       int serialPort = Serial.serialOpen("/dev/ttyACM0", 57600);
       MP3Player player1 = new MP3Player(new File("./Sounds/warning.mp3"));
       MP3Player player2 = new MP3Player(new File("./Sounds/Alarm.mp3"));
       
	public void run(){
		for(int i = 0; i < 3; i++){
			System.out.println("Emergency System Operation - センサーから異常感知");
			player1.play();			
			
			final int LED1 = 15;
			final int LED2 = 16;
			final int LED3 = 26;
			final int LED4 = 27;
			
			final int LED5R = 28;
			 
			final int ON = 0;
			final int OFF = 1;
			//GPIOを初期化
			Gpio.wiringPiSetup();
			//各LEDを出力に設定
			Gpio.pinMode(LED1, Gpio.OUTPUT);
			Gpio.pinMode(LED2, Gpio.OUTPUT);
			Gpio.pinMode(LED3, Gpio.OUTPUT);                 
			Gpio.pinMode(LED4, Gpio.OUTPUT);
				 
			 //LEDを初期化   (消す)
			Gpio.digitalWrite(LED1, 0);
			Gpio.digitalWrite(LED2, 0);
			Gpio.digitalWrite(LED3, 0);
			Gpio.digitalWrite(LED4, 0);
			
			for(int k = 0; k <4; k++){
				Gpio.digitalWrite(LED1, 1);                                   
				Gpio.digitalWrite(LED2, 1);               
				Gpio.digitalWrite(LED3, 1);
				Gpio.digitalWrite(LED4, 1);
				try{
				 Thread.sleep(300);
				}catch(InterruptedException e){
				}			  
				Gpio.digitalWrite(LED1, 0);                                   
				Gpio.digitalWrite(LED2, 0);               
				Gpio.digitalWrite(LED3, 0);
				Gpio.digitalWrite(LED4, 0);
				try{
				 Thread.sleep(300);
				}catch(InterruptedException e){
				}
			}
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
			}		
			
			
			
		}
		for(int i = 0; i < 30; i++){			
			player2.play();
			System.out.println("Emergency System Operation - センサーから異常感知");
			try{
				Thread.sleep(3200);
			}catch(InterruptedException e){
			}
		}
		
	}
}

