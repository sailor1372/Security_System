import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;
public class Led {
	
	public static void Start() throws InterruptedException {
		//LEDのピン番号を宣言
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
		
		for(int i = 0; i <4; i++){
			Gpio.digitalWrite(LED1, 1);                                   
			Gpio.digitalWrite(LED2, 1);               
			Gpio.digitalWrite(LED3, 1);
			Gpio.digitalWrite(LED4, 1);
			Thread.sleep(300);			  
			Gpio.digitalWrite(LED1, 0);                                   
			Gpio.digitalWrite(LED2, 0);               
			Gpio.digitalWrite(LED3, 0);
			Gpio.digitalWrite(LED4, 0);
			Thread.sleep(300);
		}
	}
}

