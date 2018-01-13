import java.awt.Color;
import java.awt.Point;


public class Tetrominoes{

  // [currentBlock][orientation][point]
  // all four orientations, clockwise
  // for each point, fill rect, color in Color[]
  private Point[][][] Tetrominoes = {
    // Z shape
    {
      { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
      { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
      { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
      { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
    },
    // S shape
    {
      { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
      { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
    },
    // T shape
    {
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
      { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
    },
    // I shape
    {
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
    },
    // square
    {
      { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
      { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
      { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
      { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
    },
    // L shape
    {
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) },
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) }
    },
    // J shape
    {
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) },
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) }
    }

  };

  private Color[] tetroColors = { Color.red, Color.green, Color.pink, Color.cyan, Color.yellow, Color.orange, Color.blue };

  private int currentBlock;
  private int orientation;


  public Tetrominoes(){
    currentBlock = (int)(Math.random() * 6);
    orientation = 0;

  }

  // up or 8 clockwise
  // z counterclockwise
  public void rotate(int a){
    if (a == 1){
      if (orientation == 3){
        orientation = -1;
      }
      orientation++;
    }

    if (a == -1){
      if (orientation == 0){
        orientation = 4;
      }
      orientation--;
    }

  }

  public int getOrientation(){ return orientation; }
  public int getCurrentBlock(){ return currentBlock; }

  /*
  public static void main(String[] args){
    Tetrominoes test = new Tetrominoes();
    System.out.println(test.getOrientation());
    test.rotate(-1);
    System.out.println(test.getCurrentBlock());

  }

  // right left keys
  // +1 right -1 left
  public void move(int a){
    // if not at board edges

    if (a == 1){

    }
    if (a == -1){

    }
  }
  */


}
