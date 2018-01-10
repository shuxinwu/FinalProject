import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame implements ActionListener{
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_LENGTH = 20;
    private DrawCanvas canvas;

    
    public GameBoard(){
	canvas = new DrawCanvas();
	canvas.setPreferredSize(new Dimension(200,400));
	Container c = getContentPane();
	this.setContentPane(canvas);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300,600);
	setTitle("Tetris");
	setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e){
    }
    private class DrawCanvas extends JPanel{
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setColor(Color.BLACK);
	    g.fillRect(0,0,200,400);
	}
    }
					     

    public static void main(String[] args){
	new GameBoard();
	
    }
}
