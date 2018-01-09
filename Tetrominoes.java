import java.awt.Color;

/*
enum Tetrominoes{
    ZShape(new int[][]{{0,-1},{0,0},{-1,0},{1,-1}}),
    SShape(new int[][]{{0,-1},{0,0},{1,0},{-1,-1}}),
    TShape(new int[][]{{0,-1},{0,0},{1,0},{0,1}}),
    IShape(new int[][]{{0,-1},{0,0},{0,1},{0,2}}),
    SquareShape(new int[][]{{0,0},{1,0},{0,1},{1,1}}),
    Lshape(new int[][]{{1,-1},{0,-1},{0,0},{0,1}}),
    MirrorLShape(new int[][]{{-1,-1},{0,-1},{0,0},{0,1}});
    public int[][] coords;

    private Tetrominoes(int[][] coords ){
	this.coords = coords;
    }
*/
public class Tetrominoes{

  // shapes in the order above
  // all four orientations, clockwise
  private Point[][][] Tetrominoes = {
    {
        { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
        { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
        { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
        { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
    },
    {
       { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
        { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
        { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
        { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
    },
    {
      { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
        { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
        { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
        { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
    },
    {
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
        { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
        { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
        { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
    },
    {
      { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
        { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
        { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
        { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
    },
    {
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
        { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
        { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
        { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
    },
    {
      { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
        { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
        { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
        { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
    }

  }

    private Color[] tetroColors = { Color.red, Color.green, Color.pink, Color.cyan, Color.yellow, Color.orange, Color.blue };

    // +1 clockwise -1 counterclockwise

    public void rotate(int a){
      if (a < 0){

      }
    }
}
