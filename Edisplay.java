// GPIO 処理
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;
// SPI 通信処理
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiFactory;
// 有機 EL 処理
import eu.ondryaso.ssd1306.Display;
// 画像処理
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Edisplay{
   
	public static void Start() throws IOException, InterruptedException {
       
        
         // GPIO を初期化
         Gpio.wiringPiSetup();
         
         // 有機 EL ディスプレイの初期化処理
         Display disp = new Display(128, 64, GpioFactory.getInstance(),
         SpiFactory.getInstance(SpiChannel.CS0, 8000000),
         RaspiPin.GPIO_05, RaspiPin.GPIO_04);
         disp.begin();
         
         disp.getGraphics().setFont(new Font("Serif", Font.PLAIN, 10));
         disp.getGraphics().setColor(Color.WHITE);
         
         disp.getGraphics().clearRect(0,0,128,64);
         
         for(int i = 0; i < 5; i++){
              disp.getGraphics().drawString("System Operation", 20, 10);
              disp.displayImage(); 
              Thread.sleep(1000);
              disp.getGraphics().drawString("E1", 60, 40);
              disp.displayImage();  
              Thread.sleep(1000);     
              disp.getGraphics().clearRect(0,0,128,64);   
              disp.displayImage(); 
              Thread.sleep(1000);    
		  }
	  }
    public static void main(String[] args)  throws IOException, InterruptedException{
       Edisplay e = new Edisplay();
       e.Start();
    }
  }
