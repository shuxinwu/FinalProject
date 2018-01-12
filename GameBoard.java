import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;

public class GameBoard extends JFrame implements ActionListener{
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_LENGTH = 20;
    private DrawCanvas canvas;
    private  Point  [][] Tetrominoes = {
	{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
	{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
	{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
	{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
    };
    private Timer timer;
    private Boolean isfalling;
    //  private Tetrominoes shape;
    
    public GameBoard(){
	setFocusable(true);
	//	shape = new Tetrominoes();
	canvas = new DrawCanvas();
	canvas.setPreferredSize(new Dimension(200,400));
	Container c = getContentPane();
	this.setContentPane(canvas);
	isfalling = true;
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300,600);
	setTitle("Tetris");
	setVisible(true);
	//addKeyListener(new KeyAdapter());
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
	for(int x =0 ; x< Tetrominoes[0].length ; x++){
	    if (Tetrominoes[0][x].getY() == 20){
		isfalling = false;
	    }
	}
	if(isfalling){	
	    for (int x = 0 ; x < Tetrominoes[0].length;x++){
		Tetrominoes[0][x].translate(0,1);
	    }
	}
    }

    private class DrawCanvas extends JPanel{
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setColor(Color.BLACK);
	    g.fillRect(0,0,200,400);
	    g.setColor(Color.RED);
	    for(int x = 0; x < Tetrominoes[0].length;x++){
		g.fillRect(100-(int)Tetrominoes[0][x].getX() *20,(int)Tetrominoes[0][x].getY()*20, 20, 20);
	    }
	    
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

    public static void main(String[] args){
	new GameBoard();
    }
}
 
  
