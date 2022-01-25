import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;
import com.pi4j.wiringpi.Serial;

public class AlertSound{
       Led led = new Led();
       Edisplay el = new Edisplay();
       int serialPort = Serial.serialOpen("/dev/ttyACM0", 57600);
       MP3Player player1 = new MP3Player(new File("./Sounds/warning.mp3"));
       MP3Player player2 = new MP3Player(new File("./Sounds/Alarm.mp3"));
       
       public void a1() throws IOException,InterruptedException {               
                player1.play();
                led.Start();
                if((char)Serial.serialGetchar(serialPort) == 'd' ){               
                  System.out.println("\n\n==========OPEN==========");
                  System.exit(0);	
               }
      }
         public void a2()throws IOException, InterruptedException {               
                player2.play();
                if((char)Serial.serialGetchar(serialPort) == 'd' ){				
                  System.out.println("\n\n==========OPEN==========");
                  System.exit(0);	
               }
         }
}
