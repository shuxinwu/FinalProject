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
    private static Color[][] board;

    private int score;
    private int LinesCleared;
    private boolean tetris;
    private Color[][] Next;
    
    public GameBoard(){      
	shape = new  Tetrominoes();
	nextShape = (int)(Math.random()*7);
	score = 0;
        LinesCleared = 0;
    }
    //initializes the board
    public void makeBoard(){
	board = new Color [BOARD_WIDTH][BOARD_LENGTH];
	for (int i = 0; i < 10; i++){
	    for (int x = 0; x < 21; x++){
		board [i][x] = Color.BLACK;
	    }
	}
	newPiece();
    }
    // move piece
    public void movePiece(int x, int y){
	if (!collision(pieceLoc.x + x, pieceLoc.y + y, orientation)){
	    if (x == 0){
		pieceLoc.y += y;
	    }
	    if (x == 1){
		pieceLoc.x += 1;
	    }
	    if (x == -1){
		pieceLoc.x -= 1;
	    }
	}
    }
    // newPiece is created
    public void newPiece(){
	pieceLoc = new Point(4,0);
	orientation = 0;
	curShape = nextShape;
	nextShape = (int)(Math.random()*7);

    }
    // clear lines and move lines down
    public void clearLines(){
      int cleared = 0;
	for(int i = BOARD_LENGTH - 1 ;i > 0; i--){
	    boolean fill = true;
	    for(int x = 0; x < BOARD_WIDTH ; x++){
		if(board[x][i] == Color.BLACK){
		    fill = false;
		}
	    }
	    if(fill){
		for(int y = i; y > 0;y--){
		    for(int j = 0; j <BOARD_WIDTH; j ++){
			board[j][y] = board[j][y-1];
		    }
		}
		i++;
    cleared++;
	        LinesCleared++;
	    }
	    repaint();
	}
  countScore(cleared);
    }
    // when tetris blocks reaches a certain height the game is over
    public static boolean GameOver(){
	for(int x  = 0;x < BOARD_WIDTH; x++){
	    if (board[x][1] != Color.BLACK){
		return true;
	    }
  }
	return false;
    }
    // tetrominoes moveDown
    public void moveDown(){
	if (!collision(pieceLoc.x, pieceLoc.y + 1, orientation)) {
	    pieceLoc.y += 1;
	} else {
	    stick();
      
	}
	repaint();
    }
    // checks to see if a move is possible
    public boolean collision(int x,int y, int rotate){
	for(int i = 0; i< 4; i++){
	    try{if ((board [shape.getBlock(curShape)[rotate][i].x + x][shape.getBlock(curShape)[rotate][i].y + y] != Color.BLACK) || (shape.getBlock(curShape)[rotate][i].y + y > 20 ) || (shape.getBlock(curShape)[rotate][i].x + x > 10 )){
		return true;
		}}
	    catch(ArrayIndexOutOfBoundsException e){
		return true;
	    }
	}
	return false;
    }
    // embeds the piece into the board array if it touches the bottom or another piece
  public void stick(){
	for (int i = 0; i< shape.getBlock(curShape)[orientation].length; i++ ) {
	    board[pieceLoc.x + shape.getBlock(curShape)[orientation][i].x][shape.getBlock(curShape)[orientation][i].y+ pieceLoc.y] = shape.getColor(curShape);
	}
	score += 50;
	newPiece();
    }
    // instantly drop the piece down
    public void instDrop(){
	while(pieceLoc.y > 0){
	    moveDown();
	}
    }

    // draws the board and make score and title
    public void paintComponent(Graphics g){
	g.fillRect(0,0,26 * BOARD_WIDTH,26 * BOARD_LENGTH);
	for(int i = 0; i <10; i++){
	    for(int x = 0; x< 21; x++){
		g.setColor(board[i][x]);
		g.fillRect(26* i , 26 * x, 25,25);
	    }
	}
	// draws nestPiece
  g.setColor(shape.getColor(nextShape));
	for(int i = 0; i < shape.getBlock(nextShape)[0].length; i++){
	    g.fillRect(300 + (shape.getBlock(nextShape)[0][i].x) * 26, 300 + (shape.getBlock(nextShape)[0][i].y) * 26,25,25);
  }
  g.setColor(Color.ORANGE);
	g.setFont(new Font("SansSerif", Font.BOLD, 40));
	g.drawString("TETRIS", 300, 50);
  
	g.setColor(Color.BLACK);
	g.setFont(new Font("SansSerif", Font.PLAIN, 20));
	g.drawString("Score: "+ score, 300, 120);
	g.drawString("Lines: "+ LinesCleared, 300, 220);
  g.drawString("Next", 300, 290);
  // creates GameOver Screen
  if (GameOver()){
    g.setColor(Color.RED);
    g.setFont(new Font("SansSerif", Font.BOLD, 25));
    g.drawString("GAME OVER", 300, 520);
  }
	draw(g);
    }
    // draw the shapes
    public void draw(Graphics g){
	g.setColor(shape.getColor(curShape));
	for(int i = 0; i < shape.getBlock(curShape)[orientation].length; i++){
	    g.fillRect((shape.getBlock(curShape)[orientation][i].x+ pieceLoc.x) * 26,(shape.getBlock(curShape)[orientation][i].y+pieceLoc.y) * 26,25,25);}
    }

    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    //conrtol the piece
    public void keyPressed(KeyEvent e){
	int a = e.getKeyCode();
	if(a == KeyEvent.VK_UP || a == KeyEvent.VK_NUMPAD8){
	    if (orientation == 0){
		if(!collision(pieceLoc.x, pieceLoc.y, 3)){
		    orientation = 3;
		}
	    }
	    else{
		if(!collision(pieceLoc.x, pieceLoc.y, orientation - 1)){
		    orientation--;
		}
	    }
	}
	if(a == KeyEvent.VK_RIGHT || a == KeyEvent.VK_NUMPAD6){
	    movePiece(1,0);
	}
	if(a == KeyEvent.VK_LEFT || a == KeyEvent.VK_NUMPAD4){
	    movePiece(-1,0);
	}
	if(a == KeyEvent.VK_DOWN || a == KeyEvent.VK_NUMPAD2){
	    movePiece(0,2);
	    score += 20;
	}
	if(a == KeyEvent.VK_SPACE || a == KeyEvent.VK_NUMPAD5){
	    instDrop();
	}
	if(a == KeyEvent.VK_ESCAPE){
	    makeBoard();
	    score = 0;
	    LinesCleared = 0;
	    new Thread() {
		// keeps game running unless it ends
		public void run() {
		    while (!GameOver()) {
			try {
			    Thread.sleep(400);
			    moveDown();
			    clearLines();
			}
			catch ( InterruptedException e ) {}
		    }
		}
	    }.start();
	}

    }
    // creates the GUI
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
	    // keeps game running unless it ends
	    public void run() {
		while (!a.GameOver()) {
		    try {
			Thread.sleep(400);
			a.moveDown();
			a.clearLines();
		    }
		    catch ( InterruptedException e ) {}
		}
	    }
	}.start();
	f.setVisible(true);
    }

    // after lines are cleared
    public void countScore(int l){
	if (l < 4){
	    score += l*100;
	    tetris = false;
	}
	if (l == 4){
	    if (tetris){
		score += 1600;
	    }
	    score += 800;
	    tetris = true;
	}
    }


}
