import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
public class GameBoard extends JFrame {
    private int BOARD_WIDTH;
    private int BOARD_LENGTH;
    private Timer timer;
    private boolean isFalling;
    private Shapes current;

    
    public GameBoard(){
	BOARD_WIDTH = 10;
	BOARD_LENGTH = 20;
	this.setSize(600,400);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	current = new Shape();
	timer = new Timer(400,this);
	
    }

    public void actionPerformed(ActionEvent e){
    }

    public void paint(Graphics g){
	super.paint(g);

	for (int i = 0; i < BOARD_WIDTH; i ++){
	    for(int x = 0; x< BOARD_LENGTH; x++){
		g.fillRect(5,5,5,5);
	    }
	}
    }
    
    public static void main(String[] args){
	GameBoard a = new Gameboard();
	a.setvisible(true);
	
    }
}
