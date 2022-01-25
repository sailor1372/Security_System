/*
 * Music.java
 *
 * SK1B_13_コチャンヒョン
 */

// WringPi用import
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;

// ディスプレイ用import
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiFactory;
import eu.ondryaso.ssd1306.Display;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

// MP3Player用import
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
		
        //playerオブジェクトの作成と初期化
        String[] musicList = {"lastboss02","healing08","jingle03","neorock73"}; //曲名を配列で管理
        int songMax = musicList.length;  //最大曲数
        int songNumber = 0;              //現在の曲番号

        MP3Player player = new MP3Player();
        
        // 曲名のMP3ファイルをプレイヤーに設定
            player.addToPlayList(new File("./Sound/Alarm.mp3"));
        

        System.out.println("MP3 Player処理開始");


      
                Gpio.pwmWrite(BUZZER,50);    //Dudty = 50%			
                Gpio.pwmSetClock(192000 / 650); 
                Thread.sleep(500);  
                Gpio.pwmSetClock(0);
                Thread.sleep(100);
                
                
                disp.getGraphics().clearRect(0,20,128,20);
                disp.getGraphics().drawString(musicList[songNumber], 0, 30);
                disp.displayImage();
                player.skipBackward();
                
            }

}
