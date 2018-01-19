import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;


public class GameBoard extends JLabel implements KeyListener{
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_LENGTH = 21;

    private Tetrominoes shape;
    private int curShape;
    private int nextShape;
    private int orientation;
    private Point pieceLoc;
    private Color[][] board;
	
    public GameBoard(){
	shape = new  Tetrominoes();
	nextShape = (int)(Math.random()*6);
    }

    public void makeBoard(){
	board = new Color [BOARD_WIDTH][BOARD_LENGTH];
	for (int i = 0; i < 10; i++){
	    for (int x = 0; x < 21; x++){
		if(x == 20){
		    board[i][x] = Color.GRAY;
		}
		board [i][x] = Color.BLACK;
	    }
	}
	newPiece();
    }

    public void move(){
    }
    

    public void newPiece(){
	pieceLoc = new Point(5,0);
	orientation = 0;
	curShape = nextShape;
	nextShape = (int)(Math.random()*6);

    }

    public void clearLines(){
	
	for(int i = BOARD_LENGTH -1 ;i > 0; i--){
	    boolean fill = true;
	    for(int x = 0; x < BOARD_WIDTH - 1; x++){
		if(board[x][i] == Color.BLACK){
		    fill = false;
		}
	    }
	    if(fill){
		for(int j = 0; j <BOARD_WIDTH -1; j ++){
		    board[i][j] = board[i-1][j];
		}
	    }
	    repaint();
	}
    }
    
    public void moveDown(){
	if (!collision(pieceLoc.x, pieceLoc.y + 1, orientation)) {
	    pieceLoc.y += 1;
	} else {
	    stick();
	    newPiece();
	}
	repaint();
    }

    public boolean collision(int x,int y, int rotate){
	for(int i = 0; i< 4; i++){
	    if (board [shape.getBlock(curShape)[rotate][i].x + x][shape.getBlock(curShape)[rotate][i].y + y] != Color.BLACK ){
		return true;
	    }
	}
	return false;
    }


    public void stick(){
	for (int i = 0; i< shape.getBlock(curShape)[0].length; i++ ) {
	    board[pieceLoc.x + shape.getBlock(curShape)[0][i].x][shape.getBlock(curShape)[0][i].y+ pieceLoc.y] = shape.getColor(curShape);
	}
	newPiece();
    }

    @Override
    public void paintComponent(Graphics g){
	g.fillRect(0,0,26 * BOARD_WIDTH,26 * BOARD_LENGTH);
	for(int i = 0; i <10; i++){
	    for(int x = 0; x< 21; x++){
		g.setColor(board[i][x]);
		g.fillRect(26* i , 26 * x, 25,25);
	    }
	}
	draw(g);
    }

    public void draw(Graphics g){
	g.setColor(shape.getColor(curShape));
	for(int i = 0; i < shape.getBlock(curShape)[orientation].length; i++){
	    g.fillRect((shape.getBlock(curShape)[orientation][i].x+ pieceLoc.x) * 26,(shape.getBlock(curShape)[orientation][i].y+pieceLoc.y) * 26,25,25);}
    }

    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e){
	int a = e.getKeyCode();
	if(a == KeyEvent.VK_UP || a == KeyEvent.VK_NUMPAD8){
	    //   rotate(1);
	    if (orientation == 3){
		orientation = -1;
	    }
	    orientation++;

	    //   curShape = Tetrominoes[orientation];
	    //     System.out.println(getOrientation());
	    System.out.println("rotate c");
	}
	if(a == KeyEvent.VK_RIGHT || a == KeyEvent.VK_NUMPAD6){
	    for (int x = 0 ; x < shape.getBlock(curShape)[orientation].length ;x++){
		shape.getBlock(curShape)[orientation][x].translate(1,0);
	    }
	    System.out.println("right");
	}
	if(a == KeyEvent.VK_LEFT || a == KeyEvent.VK_NUMPAD4){
	    for (int x = 0 ; x < shape.getBlock(curShape)[orientation].length;x++){
		shape.getBlock(curShape)[orientation][x].translate(-1,0);
	    }
	    System.out.println("left");
	}
	if(a == KeyEvent.VK_DOWN || a == KeyEvent.VK_NUMPAD2){
	    // faster move down
	    for (int x = 0 ; x < shape.getBlock(curShape)[orientation].length;x++){
		shape.getBlock(curShape)[orientation][x].translate(0,1);
	    }
	    System.out.println("down");
	}
	if(a == KeyEvent.VK_SPACE || a == KeyEvent.VK_NUMPAD5){
	    // instant drop
	    System.out.println("drop");
	}
	if(a == KeyEvent.VK_Z){
	    // rotate(-1);
	    if (orientation == 0){
		orientation = 4;
	    }
	    orientation--;

	    //   curShape = Tetrominoes[orientation];
	    //   System.out.println(getOrientation());
	    System.out.println("rotate cc");
	}
    }

    public static void main(String[] args){
	JFrame f = new JFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(500,700);
	f.setTitle("Tetris");
	GameBoard a = new GameBoard();
	a.makeBoard();
	f.add(a);
	f.addKeyListener(a);
	new Thread() {
	    @Override public void run() {
		while (true) {
		    try {
			Thread.sleep(400);
			a.moveDown();
			a.clearLines();
		    } catch ( InterruptedException e ) {}
		}
	    }
	}.start();
	f.setVisible(true);
    }
}
