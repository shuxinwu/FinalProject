import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GameBoard extends JFrame {
    private int BOARD_WIDTH;
    private int BOARD_LENGTH;
    private Timer timer;
    private boolean isFalling;
    private Shapes current;
    
    public GameBoard(){
	current = new Shape();
	timer = new Timer(400,this);

    }

    public void actionPerformed(ActionEvent e){
    }

    public static void main(String[] args){
    }
}
