import java.awt.Color;

public class Tetrominoes{

  // shapes in the order above
  // all four orientations, clockwise
  private Point[][][] Tetrominoes = {
    // Z shape
    {
      { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
      { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
    },
    // S shape
    {
      { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
      { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
      { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
      { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
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
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
    },
    // J shape
    {
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
      { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
    }

  }

  private Color[] tetroColors = { Color.red, Color.green, Color.pink, Color.cyan, Color.yellow, Color.orange, Color.blue };

  private int currentPiece;
  private int orientation;

  // +1 clockwise -1 counterclockwise
  public void rotate(int a){
    if (a == 1){
      if (orientation == 3){
        orientation = 0;
      }
      orientation++;
    }
    if (a == -1){
      if (orientation == 0){
        orientation = 3;
      }
      orientation--;
    }
  }

  // rand piece rand orientation

}
