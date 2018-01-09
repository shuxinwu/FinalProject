import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
public class GameBoard extends JFrame implements ActionListener{
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_LENGTH = 20;
    private Timer timer;
    private boolean isFalling;
    private Shapes current;

    
    public GameBoard(){
	Timer timer;
	this.setSize(600,400);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	current = new Shapes();
	timer = new Timer(400, this);
	timer.start();
    }

    private void clearBoard(){
    }
    
    public void actionPerformed(ActionEvent e){
    }

    public void paint(Graphics g){
	super.paint(g);
	g.fillRect(0,0,10,20);
	    
	}

    public static void main(String[] args){
	GameBoard a = new Gameboard();
	a.setvisible(true);
	
    }
}
