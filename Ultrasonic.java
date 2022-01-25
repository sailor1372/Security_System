import com.pi4j.wiringpi.Serial;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ultrasonic {
	
    //데이터 수신
    public static class SerialReader implements Runnable {
		int serialPort = Serial.serialOpen("/dev/ttyACM0", 9600);
        InputStream in;
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        public void run ()
        {
            byte[] buffer = new byte[1024];
            int len = -1;
            
                while (true)           {
                    if((char)Serial.serialGetchar(serialPort) == 'a'){
						Alrm s1 = new Alrm();	
						System.out.println("g");					
						break;
					}
                }
            
                       
        }
    }

   
    public static void main ( String[] args ){
		Ultrasonic ul = new Ultrasonic();
        
        
    }
}
