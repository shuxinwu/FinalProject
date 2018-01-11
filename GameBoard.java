import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;

public class GameBoard extends JFrame implements ActionListener{
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_LENGTH = 20;
    private DrawCanvas canvas;
    //  private Tetrominoes shape;
    
    public GameBoard(){
	setFocusable(true);
	//	shape = new Tetrominoes();
	Point  [][] Tetrominoes = {
      { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
      { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
	};
	canvas = new DrawCanvas();
	canvas.setPreferredSize(new Dimension(200,400));
	Container c = getContentPane();
	this.setContentPane(canvas);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300,600);
	setTitle("Tetris");
	setVisible(true);
	//addKeyListener(new KeyAdapter());
	}
    public void actionPerformed(ActionEvent e){
    }
    
    private class DrawCanvas extends JPanel{
	public void paintComponent(Graphics g){
	    Point  [][] Tetrominoes = {
		{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
		{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
		{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
		{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
	    };
	    super.paintComponent(g);
	    g.setColor(Color.BLACK);
	    g.fillRect(0,0,200,400);
	    g.setColor(Color.RED);
	    /* for(int x = 0; x < Tetrominoes[0].length;x++){
		g.fillRect(100-(int)Tetrominoes[0][x].getX() *20,(int)Tetrominoes[0][x].getY()*20, 20, 20);
		}*/
	    
	}
    }
    
    /*
    public void keyPressed(KeyEvent e){
	switch(evt.getKeyCode()){
	case KeyEvent.VK_DOWN: moveDown();
	    break;
	}
    }
    */

    private void moveDown(){
    }
    public static void main(String[] args){
	new GameBoard();
	
    }
}
 
  
