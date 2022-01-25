import java.awt.*;
 
import javax.swing.*;
 
public class TimerTest extends JFrame{
    JLabel timerLabel = null;
    public TimerTest()
    {
        this.setTitle("Timer Test");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        timerLabel = new JLabel("0");
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
        c.add(timerLabel);
        this.setSize(300,150);
        this.setVisible(true);
        int k = 0;
        while(true)
        {
            timerLabel.setText(""+k);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            k++;
        }
    }
    public static void main(String[] args) {
        new TimerTest();
    }
}
