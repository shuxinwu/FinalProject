import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;

public class GameBoard extends JFrame implements ActionListener{
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_LENGTH = 20;
    private DrawCanvas canvas;
    private Tetrominoes shape;
    
    public GameBoard(){
	setFocusable(true);
	shape = new Tetrominoes();
	canvas = new DrawCanvas();
	canvas.setPreferredSize(new Dimension(200,400));
	Container c = getContentPane();
	this.setContentPane(canvas);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300,600);
	setTitle("Tetris");
	setVisible(true);
	addKeyListener(new KeyAdapter());
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
    public void keyPressed(KeyEvent e){
	switch(evt.getKeyCode()){
	case KeyEvent.VK_DOWN: moveDown();
	    break;
	}
    }
    private void moveDown(){
    }
    public static void main(String[] args){
	new GameBoard();
	
    }
}
 
  
