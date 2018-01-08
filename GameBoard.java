import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GameBoardextends JFrame {
    private int BOARD_WIDTH;
    private int BOARD_LENGTH;
    private Timer timer;
    private boolean isFalling;
    private Shapes current
    
    public Board(){
	current = new Shape();
	timer = new Timer(400,this);

    }

    public void actionPerformed(ActionEvent e){
    }

}
