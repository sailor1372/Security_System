
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
public class Sound {
	
       public void abc() {
             
              File alert;
              AudioInputStream stream;
              AudioFormat format;
              DataLine.Info info;
              Clip clip;
              alert = new File("D:\\ECC Project\\Sounds\\warning.wav"); 
              try {
                     stream = AudioSystem.getAudioInputStream(alert);
                     format = stream.getFormat();
                     info = new DataLine.Info(Clip.class, format);
                     clip = (Clip)AudioSystem.getLine(info);
                     clip.open(stream);
                     clip.start();
                     
              } catch (Exception e) {
                     System.out.println("err : " + e);
                     }
              
       }
       public void abc2() {           
           
           File siren;
           AudioInputStream stream2;
           AudioFormat format2;
           DataLine.Info info2;
           Clip clip2;
           siren = new File("D:\\ECC Project\\Sounds\\Alarm.wav"); 
           try {
                  
                  stream2 = AudioSystem.getAudioInputStream(siren);
                  format2 = stream2.getFormat();
                  info2 = new DataLine.Info(Clip.class, format2);
                  clip2 = (Clip)AudioSystem.getLine(info2);
                  clip2.open(stream2);
                  clip2.start();
                  
           } catch (Exception e) {
                  System.out.println("err : " + e);
                  }
            
       }
       public static void main(String[] args) {
              AlertSound test = new AlertSound();
              for(int i = 1; i < 3; i++) {
                     try {
                           test.abc();
                           Thread.sleep(2800); 
                     } catch(Exception e) {
                           
                     }
              }
              for(int i = 0; i < 5; i++) {
                  try {
                	  	test.abc2();
                        Thread.sleep(3600); 
                  } catch(Exception e) {
                        
                  }
              }
       }              
}