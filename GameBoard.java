import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;

public class GameBoard extends JLabel {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_LENGTH = 20;
    private Tetrominoes shape;
    private int curShape;
    private int nextShape;
    private int orientation;
    private Point pieceLoc;
    private Color[][] board; 
	
    public GameBoard(){
        shape = new  Tetrominoes();
	nextShape = (int)(Math.random()*6);
	/*	ActionListener a = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    if (!collision(pieceLoc.x, pieceLoc.y + 1, orientation)) {
			pieceLoc.y += 1;
		    } else {
		      	stick();
			newPiece();
		    }	
		    repaint();
		}
	    };
	timer = new Timer(400,a);
	timer.start();*/	    
    }

    public void makeBoard(){
	board = new Color [10][20];
	for (int i = 0; i < 10; i++){
	    for (int x = 0; x < 20; x++){
		board [i][x] = Color.BLACK;
	    }
	}
	newPiece();
    }

    
    

    public void newPiece(){
	pieceLoc = new Point(5,2);
	orientation = 0;
	curShape = nextShape;
	nextShape = (int)(Math.random()*6);
	
    }
    public void moveDown(){
	if (!collision(pieceLoc.x, pieceLoc.y + 1, orientation)) {
	    pieceLoc.y += 1;
	} else {
	    stick();
	}	
	repaint();
    }
    
   public boolean collision(int x,int y, int rotate){
	for(int i = 0; i< 4; i++){
	    if (board [shape.getBlock(curShape)[rotate][i].x+ pieceLoc.x][shape.getBlock(curShape)[rotate][i].y+pieceLoc.y] != Color.BLACK );{
		return true;
	    }
	}
	return false;
	}
    
     public void draw(Graphics g){
	 g.setColor(shape.getColor(curShape));
	 for(int i = 0; i < shape.getBlock(curShape)[0].length; i++){
	     g.fillRect((shape.getBlock(curShape)[0][i].x+ pieceLoc.x) * 25,(shape.getBlock(curShape)[0][i].y+pieceLoc.y) * 25,25,25);}
     }

    public void stick(){
	for (int i = 0; i< shape.getBlock(curShape)[0].length; i++ ) {
	    board[pieceLoc.x + shape.getBlock(curShape)[0][i].x][shape.getBlock(curShape)[0][i].y+ pieceLoc.y] = shape.getColor(curShape);
	}
	newPiece();
    }
    
    @Override
    public void paintComponent(Graphics g){
	g.fillRect(0,0,25 * BOARD_WIDTH,25 * BOARD_LENGTH);
	for(int i = 0; i <10; i++){
	    for(int x = 0; x< 20; x++){
		g.setColor(board[i][x]);
		g.fillRect(25* i , 25 * x, 25,25);
	    }
	}
	draw(g);
    }



    

    public static void main(String[] args){
	JFrame f = new JFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(500,1000);
	f.setTitle("Tetris");
	f.setVisible(true);
	GameBoard a = new GameBoard();
	a.makeBoard();
	f.add(a);
	new Thread() {
	    @Override public void run() {
		while (true) {
		    try {
			Thread.sleep(1000);
			a.moveDown();
		    } catch ( InterruptedException e ) {}
		}
	    }
	}.start();
    }
}
 
