import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;


public class GameBoard extends JFrame implements ActionListener,KeyListener{
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_LENGTH = 20;
    private DrawCanvas canvas;
    private Tetrominoes shape;
    private Timer timer;
    private Boolean isfalling;
    private Point [] curShape;
    private Point [] nextShape;

	
    public GameBoard(){
	setFocusable(true);
	//	shape = new Tetrominoes();
	canvas = new DrawCanvas();
	canvas.setPreferredSize(new Dimension(200,400));
	Container c = getContentPane();
	this.setContentPane(canvas);
	isfalling = true;
	curShape = Tetrominoes[(int)(Math.random()*4)];
	nextShape = Tetrominoes[(int)(Math.random()*4)];
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300,600);
	setTitle("Tetris");
	setVisible(true);
   this.addKeyListener(this);
	ActionListener a = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    update();   
		    repaint();  
		}
	    };
	timer = new Timer(400,a);
	timer.start();

	    
    }
    public void actionPerformed(ActionEvent e){
	//update();
	//	repaint();	    
    }
    public void update(){
	for(int x =0 ; x< curShape.length ; x++){
	    if (curShape[x].getY() == 20 ){
		isfalling = false;
	    }
	}
	if(isfalling){	
	    for (int x = 0 ; x < curShape.length;x++){
		curShape[x].translate(0,1);
	    }
	}
	else{curShape = nextShape;
	    nextShape = Tetrominoes[(int)(Math.random()*4)];
	    isfalling =true;
	}
    }

    private class DrawCanvas extends JPanel{
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setColor(Color.BLACK);
	    g.fillRect(0,0,200,400);
	    g.setColor(Color.RED);
	    for(int x = 0; x < curShape.length;x++){
		g.fillRect(100-(int)curShape[x].getX() *20,(int)curShape[x].getY()*20, 20, 20);
	    }
	    
	}
    }
    
	
  public void keyTyped(KeyEvent e){}
  public void keyReleased(KeyEvent e){}
  public void keyPressed(KeyEvent e){
    int a = e.getKeyCode();
    if(a == KeyEvent.VK_UP || a == KeyEvent.VK_NUMPAD8){
      //   rotate(1);
      System.out.println("rotate c");
    }
    if(a == KeyEvent.VK_RIGHT || a == KeyEvent.VK_NUMPAD6){
      //   move(1);
      // for (int x = 0 ; x < curShape.length;x++){
      //	 curShape[x].translate(1,0);
      // }
      System.out.println("right");
    }
    if(a == KeyEvent.VK_LEFT || a == KeyEvent.VK_NUMPAD4){
      //     move(-1);
      // for (int x = 0 ; x < curShape.length;x++){
      //	 curShape[x].translate(-1,0);
      // }
      System.out.println("left");
    }
    if(a == KeyEvent.VK_DOWN || a == KeyEvent.VK_NUMPAD2){
      // faster move down
      System.out.println("down");
    }
    if(a == KeyEvent.VK_SPACE || a == KeyEvent.VK_NUMPAD5){
      // instant drop
      System.out.println("drop");
    }
    if(a == KeyEvent.VK_Z){
      // rotate(-1);
      System.out.println("rotate cc");
    }
     if(a == KeyEvent.VK_P){
      // pause
      System.out.println("pause");
    }
  }

    public static void main(String[] args){
	new GameBoard();
	Tetrominoes a = new Tetrominoes();
	System.out.println(a);
	
    }
}
